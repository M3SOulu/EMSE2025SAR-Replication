package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
)

func main() {
	vendorDir := "./vendor" // 设置vendor目录的路径
	err := filepath.Walk(vendorDir, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}

		// 只处理文件夹
		if !info.IsDir() {
			return nil
		}

		// 检查是否为包目录
		if _, err := os.Stat(filepath.Join(path, "vendor.json")); os.IsNotExist(err) {
			return nil
		}

		// 读取vendor.json文件
		vendorJSON, err := ioutil.ReadFile(filepath.Join(path, "vendor.json"))
		if err != nil {
			return err
		}

		// 提取版本信息
		version := getVersionFromVendorJSON(vendorJSON)
		if version != "" {
			packageName := getPackageNameFromPath(path)
			fmt.Printf("%s: %s\n", packageName, version)
		}

		return nil
	})

	if err != nil {
		fmt.Printf("Error: %s\n", err.Error())
	}
}

func getVersionFromVendorJSON(vendorJSON []byte) string {
	// 在vendor.json中查找版本字段
	// 这里简化了解析过程，具体情况可以根据vendor.json的格式进行处理
	version := "" // 用于存储版本信息

	// 假设vendor.json文件中的版本信息位于"version"字段
	// 根据实际情况进行修改
	const versionField = `"version": "`
	startIndex := strings.Index(string(vendorJSON), versionField)
	if startIndex != -1 {
		startIndex += len(versionField)
		endIndex := strings.Index(string(vendorJSON[startIndex:]), `"`)
		if endIndex != -1 {
			version = string(vendorJSON[startIndex : startIndex+endIndex])
		}
	}

	return version
}

func getPackageNameFromPath(path string) string {
	// 根据文件路径提取包名
	// 这里简化了提取过程，具体情况可以根据vendor目录的结构进行处理
	components := strings.Split(path, string(os.PathSeparator))
	if len(components) > 2 {
		return strings.Join(components[2:], "/")
	}
	return ""
}

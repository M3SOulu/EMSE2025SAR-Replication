package main

import (
	pb "Go_C/proto"
	"context"
	"errors"
	"flag"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"log"
	"math/rand"
	"net"
	"runtime"
	"time"
)

func getCurrentFunctionName() string {
	pc, _, _, _ := runtime.Caller(1)
	function := runtime.FuncForPC(pc)
	return function.Name()
}

type server struct {
	pb.UnimplementedGo_CServer
	cnt int
}

func (s *server) Go_C_1(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("%s called by %s\n", getCurrentFunctionName(), message.GetMyString())
	message.MyString = getCurrentFunctionName()
	message.CallStack = append(message.CallStack, message.MyString)
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}
	if _, err := s.Go_C_2(ctx, message); err != nil {
		message.CallStack = message.CallStack[:len(message.CallStack)-1]
		return nil, err
	}
	if _, err := s.Go_C_3(ctx, message); err != nil {
		message.CallStack = message.CallStack[:len(message.CallStack)-1]
		return nil, err
	}
	{
		conn, err := grpc.Dial("python_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewPython_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Python_C_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("java_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewJava_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Java_B_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	message.CallStack = message.CallStack[:len(message.CallStack)-1]
	return message, nil
}

func (s *server) Go_C_2(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("%s called by %s\n", getCurrentFunctionName(), message.GetMyString())
	message.MyString = getCurrentFunctionName()
	message.CallStack = append(message.CallStack, getCurrentFunctionName())
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}

	{
		conn, err := grpc.Dial("cpp_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewCpp_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Cpp_B_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("ts_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewTs_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Ts_C_3(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	message.CallStack = message.CallStack[:len(message.CallStack)-1]
	return message, nil
}

func (s *server) Go_C_3(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("%s called by %s\n", getCurrentFunctionName(), message.GetMyString())
	message.MyString = getCurrentFunctionName()
	message.CallStack = append(message.CallStack, getCurrentFunctionName())
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}
	message.CallStack = message.CallStack[:len(message.CallStack)-1]
	return message, nil
}
func main() {

	flag.Parse()
	lis, err := net.Listen("tcp", "localhost:8080")
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterGo_CServer(s, &server{})
	log.Printf("server listening at %v", "8080")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}

package main

import (
	pb "Go_A/proto"
	"context"
	"errors"
	"flag"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"log"
	"math/rand"
	"net"
	"time"
)

// server is used to implement helloworld.GreeterServer.
type server struct {
	pb.UnimplementedGo_AServer
	cnt int
}

func (s *server) Go_A_1(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("Go_A_1 called by %s\n", message.GetMyString())
	message.MyString = "Go_A_1"
	message.CallStack = append(message.CallStack, "Go_A_1")
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}

	// function calls
	if _, err := s.Go_A_2(ctx, message); err != nil {
		message.CallStack = message.CallStack[:len(message.CallStack)-1]
		return nil, err
	}
	if _, err := s.Go_A_3(ctx, message); err != nil {
		message.CallStack = message.CallStack[:len(message.CallStack)-1]
		return nil, err
	}
	{
		conn, err := grpc.Dial("go_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewGo_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Go_B_1(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
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
		if _, err := c.Cpp_B_3(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("cpp_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewCpp_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Cpp_C_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("ts_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewTs_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Ts_B_1(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
		if _, err := c.Ts_B_3(ctx, message); err != nil {
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
		if _, err := c.Ts_C_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	message.CallStack = message.CallStack[:len(message.CallStack)-1]
	return message, nil
}

func (s *server) Go_A_2(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("Go_A_2 called by %s\n", message.GetMyString())
	message.MyString = "Go_A_2"
	message.CallStack = append(message.CallStack, "Go_A_2")
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}

	// function calls
	{
		conn, err := grpc.Dial("go_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewGo_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Go_C_1(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
		if _, err := c.Go_C_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("go_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewGo_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Go_B_3(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("java_a:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewJava_AClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Java_A_1(ctx, message); err != nil {
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
		if _, err := c.Ts_C_1(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	message.CallStack = message.CallStack[:len(message.CallStack)-1]
	return message, nil
}

func (s *server) Go_A_3(ctx context.Context, message *pb.CommonMessage) (*pb.CommonMessage, error) {
	defer func() {
		s.cnt++
	}()
	log.Printf("Go_A_3 called by %s\n", message.GetMyString())
	message.MyString = "Go_A_3"
	message.CallStack = append(message.CallStack, "Go_A_3")
	if s.cnt > 1000 {
		choice := rand.Int()
		if choice%100 == 0 {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, errors.New("fail")
		}
	}

	// function calls
	{
		conn, err := grpc.Dial("go_b:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewGo_BClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Go_B_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		if _, err := s.Go_A_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
	}
	{
		conn, err := grpc.Dial("go_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewGo_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Go_C_3(ctx, message); err != nil {
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
	{
		conn, err := grpc.Dial("cpp_c:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Printf("did not connect: %v\n", err)
		}
		defer conn.Close()
		c := pb.NewCpp_CClient(conn)
		ctx, cancel := context.WithTimeout(context.Background(), time.Second)
		defer cancel()
		if _, err := c.Cpp_C_3(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
		}
		if _, err := c.Cpp_C_2(ctx, message); err != nil {
			message.CallStack = message.CallStack[:len(message.CallStack)-1]
			return nil, err
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
	pb.RegisterGo_AServer(s, &server{})
	log.Printf("server listening at %v", "8080")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}

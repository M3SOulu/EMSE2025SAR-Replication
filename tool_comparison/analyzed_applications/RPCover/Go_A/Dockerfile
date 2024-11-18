FROM golang:1.20.5-alpine3.18

WORKDIR /app

COPY . .

RUN go mod download

RUN go build -o server ./cmd/server.go

# 声明容器运行时需要监听的端口号
EXPOSE 8080

CMD ["./server"]

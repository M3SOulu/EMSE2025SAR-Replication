import inspect
from protos.Python_C_pb2_grpc import *
from protos.Java_B_pb2_grpc import *
from protos.message_pb2 import *
from concurrent import futures
import grpc
import random


class Python_C(Python_CServicer):
    def __init__(self):
        self.cnt = 0

    def Python_C_1(self, request: CommonMessage, context):
        try:
            self.cnt += 1
            print(
                f"{inspect.currentframe().f_code.co_name} called by {request.my_string}")
            request.my_string = inspect.currentframe().f_code.co_name
            request.call_stack.append(inspect.currentframe().f_code.co_name)
            if self.cnt > 1000:
                choice = random.randint(0, 100)
                if choice % 100 == 0:
                    request.call_stack = request.call_stack[:-1]
                    raise Exception("fail")

            with grpc.insecure_channel('python_c:8080') as channel:
                stub = Python_CStub(channel)
                stub.Python_C_2(request)
                stub.Python_C_3(request)
            with grpc.insecure_channel('java_b:8080') as channel:
                stub = Java_BStub(channel)
                stub.Java_B_1(request)
            return request
        except Exception as e:
            print(e, request.call_stack)
            request.call_stack = request.call_stack[:-1]
            return request

    def Python_C_2(self, request: CommonMessage, context):
        try:
            self.cnt += 1
            print(
                f"{inspect.currentframe().f_code.co_name} called by {request.my_string}")
            request.my_string = inspect.currentframe().f_code.co_name
            request.call_stack.append(inspect.currentframe().f_code.co_name)
            if self.cnt > 1000:
                choice = random.randint(0, 100)
                if choice % 100 == 0:
                    request.call_stack = request.call_stack[:-1]
                    raise Exception("fail")

            self.Python_C_3(request, context)
            with grpc.insecure_channel('java_b:8080') as channel:
                stub = Java_BStub(channel)
                stub.Java_B_2(request)
                stub.Java_B_1(request)
            return request
        except Exception as e:
            print(e, request.call_stack)
            request.call_stack = request.call_stack[:-1]
            return request

    def Python_C_3(self, request: CommonMessage, context):
        try:
            self.cnt += 1
            print(
                f"{inspect.currentframe().f_code.co_name} called by {request.my_string}")
            request.my_string = inspect.currentframe().f_code.co_name
            request.call_stack.append(inspect.currentframe().f_code.co_name)
            if self.cnt > 1000:
                choice = random.randint(0, 100)
                if choice % 100 == 0:
                    request.call_stack = request.call_stack[:-1]
                    raise Exception("fail")
            self.Python_C_1(request, context)
            with grpc.insecure_channel('java_b:8080') as channel:
                stub = Java_BStub(channel)
                stub.Java_B_3(request)
                stub.Java_B_2(request)

            return request
        except Exception as e:
            print(e, request.call_stack)
            request.call_stack = request.call_stack[:-1]
            return request


if __name__ == '__main__':
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    add_Python_CServicer_to_server(Python_C(), server)
    server.add_insecure_port('[::]:8080')
    server.start()
    server.wait_for_termination()

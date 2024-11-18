from __future__ import print_function

import logging
import random
from protos.message_pb2 import CommonMessage, MyEnum, InnerMessage
from google.protobuf.timestamp_pb2 import Timestamp
from google.protobuf.any_pb2 import Any
from google.protobuf.duration_pb2 import Duration
import grpc

import protos.message_pb2
from protos.Python_A_pb2 import *
from protos.Ts_A_pb2_grpc import *
from protos.message_pb2 import *


def run():
    with grpc.insecure_channel('localhost:8080') as channel:
        stub = Ts_AStub(channel)
        message = CommonMessage(my_string="fuck", my_bool=True)
        response = stub.Ts_A_1(message)
        print(response)


if __name__ == '__main__':
    run()

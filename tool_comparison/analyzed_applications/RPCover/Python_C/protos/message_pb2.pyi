from google.protobuf import timestamp_pb2 as _timestamp_pb2
from google.protobuf import any_pb2 as _any_pb2
from google.protobuf import duration_pb2 as _duration_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor
ENUM_VALUE_1: MyEnum
ENUM_VALUE_2: MyEnum
ENUM_VALUE_3: MyEnum

class CommonMessage(_message.Message):
    __slots__ = ["call_stack", "inner_message", "my_any", "my_bool", "my_bytes", "my_duration", "my_enum", "my_float", "my_int32", "my_int32_field", "my_map", "my_numbers", "my_string", "my_string_field", "my_timestamp"]
    class MyMapEntry(_message.Message):
        __slots__ = ["key", "value"]
        KEY_FIELD_NUMBER: _ClassVar[int]
        VALUE_FIELD_NUMBER: _ClassVar[int]
        key: str
        value: int
        def __init__(self, key: _Optional[str] = ..., value: _Optional[int] = ...) -> None: ...
    CALL_STACK_FIELD_NUMBER: _ClassVar[int]
    INNER_MESSAGE_FIELD_NUMBER: _ClassVar[int]
    MY_ANY_FIELD_NUMBER: _ClassVar[int]
    MY_BOOL_FIELD_NUMBER: _ClassVar[int]
    MY_BYTES_FIELD_NUMBER: _ClassVar[int]
    MY_DURATION_FIELD_NUMBER: _ClassVar[int]
    MY_ENUM_FIELD_NUMBER: _ClassVar[int]
    MY_FLOAT_FIELD_NUMBER: _ClassVar[int]
    MY_INT32_FIELD_FIELD_NUMBER: _ClassVar[int]
    MY_INT32_FIELD_NUMBER: _ClassVar[int]
    MY_MAP_FIELD_NUMBER: _ClassVar[int]
    MY_NUMBERS_FIELD_NUMBER: _ClassVar[int]
    MY_STRING_FIELD_FIELD_NUMBER: _ClassVar[int]
    MY_STRING_FIELD_NUMBER: _ClassVar[int]
    MY_TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    call_stack: _containers.RepeatedScalarFieldContainer[str]
    inner_message: InnerMessage
    my_any: _any_pb2.Any
    my_bool: bool
    my_bytes: bytes
    my_duration: _duration_pb2.Duration
    my_enum: MyEnum
    my_float: float
    my_int32: int
    my_int32_field: int
    my_map: _containers.ScalarMap[str, int]
    my_numbers: _containers.RepeatedScalarFieldContainer[int]
    my_string: str
    my_string_field: str
    my_timestamp: _timestamp_pb2.Timestamp
    def __init__(self, my_string: _Optional[str] = ..., my_int32: _Optional[int] = ..., my_float: _Optional[float] = ..., my_bool: bool = ..., my_enum: _Optional[_Union[MyEnum, str]] = ..., my_numbers: _Optional[_Iterable[int]] = ..., inner_message: _Optional[_Union[InnerMessage, _Mapping]] = ..., my_string_field: _Optional[str] = ..., my_int32_field: _Optional[int] = ..., my_bytes: _Optional[bytes] = ..., my_map: _Optional[_Mapping[str, int]] = ..., my_timestamp: _Optional[_Union[_timestamp_pb2.Timestamp, _Mapping]] = ..., my_any: _Optional[_Union[_any_pb2.Any, _Mapping]] = ..., my_duration: _Optional[_Union[_duration_pb2.Duration, _Mapping]] = ..., call_stack: _Optional[_Iterable[str]] = ...) -> None: ...

class InnerMessage(_message.Message):
    __slots__ = ["inner_value"]
    INNER_VALUE_FIELD_NUMBER: _ClassVar[int]
    inner_value: int
    def __init__(self, inner_value: _Optional[int] = ...) -> None: ...

class MyEnum(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

/* eslint-disable */
import _m0 from "protobufjs/minimal";
import { Any } from "../google/protobuf/any";
import { Duration } from "../google/protobuf/duration";
import { Timestamp } from "../google/protobuf/timestamp";

export const protobufPackage = "protos";

export enum MyEnum {
  ENUM_VALUE_1 = 0,
  ENUM_VALUE_2 = 1,
  ENUM_VALUE_3 = 2,
  UNRECOGNIZED = -1,
}

export function myEnumFromJSON(object: any): MyEnum {
  switch (object) {
    case 0:
    case "ENUM_VALUE_1":
      return MyEnum.ENUM_VALUE_1;
    case 1:
    case "ENUM_VALUE_2":
      return MyEnum.ENUM_VALUE_2;
    case 2:
    case "ENUM_VALUE_3":
      return MyEnum.ENUM_VALUE_3;
    case -1:
    case "UNRECOGNIZED":
    default:
      return MyEnum.UNRECOGNIZED;
  }
}

export function myEnumToJSON(object: MyEnum): string {
  switch (object) {
    case MyEnum.ENUM_VALUE_1:
      return "ENUM_VALUE_1";
    case MyEnum.ENUM_VALUE_2:
      return "ENUM_VALUE_2";
    case MyEnum.ENUM_VALUE_3:
      return "ENUM_VALUE_3";
    case MyEnum.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export interface InnerMessage {
  innerValue: number;
}

export interface CommonMessage {
  myString: string;
  myInt32: number;
  myFloat: number;
  myBool: boolean;
  myEnum: MyEnum;
  myNumbers: number[];
  innerMessage: InnerMessage | undefined;
  myStringField?: string | undefined;
  myInt32Field?: number | undefined;
  myBytes: Uint8Array;
  myMap: { [key: string]: number };
  myTimestamp: Date | undefined;
  myAny: Any | undefined;
  myDuration: Duration | undefined;
  callStack: string[];
}

export interface CommonMessage_MyMapEntry {
  key: string;
  value: number;
}

function createBaseInnerMessage(): InnerMessage {
  return { innerValue: 0 };
}

export const InnerMessage = {
  encode(message: InnerMessage, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.innerValue !== 0) {
      writer.uint32(8).int32(message.innerValue);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): InnerMessage {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseInnerMessage();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.innerValue = reader.int32();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): InnerMessage {
    return { innerValue: isSet(object.innerValue) ? Number(object.innerValue) : 0 };
  },

  toJSON(message: InnerMessage): unknown {
    const obj: any = {};
    message.innerValue !== undefined && (obj.innerValue = Math.round(message.innerValue));
    return obj;
  },

  create<I extends Exact<DeepPartial<InnerMessage>, I>>(base?: I): InnerMessage {
    return InnerMessage.fromPartial(base ?? {});
  },

  fromPartial<I extends Exact<DeepPartial<InnerMessage>, I>>(object: I): InnerMessage {
    const message = createBaseInnerMessage();
    message.innerValue = object.innerValue ?? 0;
    return message;
  },
};

function createBaseCommonMessage(): CommonMessage {
  return {
    myString: "",
    myInt32: 0,
    myFloat: 0,
    myBool: false,
    myEnum: 0,
    myNumbers: [],
    innerMessage: undefined,
    myStringField: undefined,
    myInt32Field: undefined,
    myBytes: new Uint8Array(0),
    myMap: {},
    myTimestamp: undefined,
    myAny: undefined,
    myDuration: undefined,
    callStack: [],
  };
}

export const CommonMessage = {
  encode(message: CommonMessage, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.myString !== "") {
      writer.uint32(10).string(message.myString);
    }
    if (message.myInt32 !== 0) {
      writer.uint32(16).int32(message.myInt32);
    }
    if (message.myFloat !== 0) {
      writer.uint32(29).float(message.myFloat);
    }
    if (message.myBool === true) {
      writer.uint32(32).bool(message.myBool);
    }
    if (message.myEnum !== 0) {
      writer.uint32(40).int32(message.myEnum);
    }
    writer.uint32(50).fork();
    for (const v of message.myNumbers) {
      writer.int32(v);
    }
    writer.ldelim();
    if (message.innerMessage !== undefined) {
      InnerMessage.encode(message.innerMessage, writer.uint32(58).fork()).ldelim();
    }
    if (message.myStringField !== undefined) {
      writer.uint32(66).string(message.myStringField);
    }
    if (message.myInt32Field !== undefined) {
      writer.uint32(72).int32(message.myInt32Field);
    }
    if (message.myBytes.length !== 0) {
      writer.uint32(82).bytes(message.myBytes);
    }
    Object.entries(message.myMap).forEach(([key, value]) => {
      CommonMessage_MyMapEntry.encode({ key: key as any, value }, writer.uint32(90).fork()).ldelim();
    });
    if (message.myTimestamp !== undefined) {
      Timestamp.encode(toTimestamp(message.myTimestamp), writer.uint32(98).fork()).ldelim();
    }
    if (message.myAny !== undefined) {
      Any.encode(message.myAny, writer.uint32(106).fork()).ldelim();
    }
    if (message.myDuration !== undefined) {
      Duration.encode(message.myDuration, writer.uint32(114).fork()).ldelim();
    }
    for (const v of message.callStack) {
      writer.uint32(122).string(v!);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): CommonMessage {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseCommonMessage();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.myString = reader.string();
          continue;
        case 2:
          if (tag !== 16) {
            break;
          }

          message.myInt32 = reader.int32();
          continue;
        case 3:
          if (tag !== 29) {
            break;
          }

          message.myFloat = reader.float();
          continue;
        case 4:
          if (tag !== 32) {
            break;
          }

          message.myBool = reader.bool();
          continue;
        case 5:
          if (tag !== 40) {
            break;
          }

          message.myEnum = reader.int32() as any;
          continue;
        case 6:
          if (tag === 48) {
            message.myNumbers.push(reader.int32());

            continue;
          }

          if (tag === 50) {
            const end2 = reader.uint32() + reader.pos;
            while (reader.pos < end2) {
              message.myNumbers.push(reader.int32());
            }

            continue;
          }

          break;
        case 7:
          if (tag !== 58) {
            break;
          }

          message.innerMessage = InnerMessage.decode(reader, reader.uint32());
          continue;
        case 8:
          if (tag !== 66) {
            break;
          }

          message.myStringField = reader.string();
          continue;
        case 9:
          if (tag !== 72) {
            break;
          }

          message.myInt32Field = reader.int32();
          continue;
        case 10:
          if (tag !== 82) {
            break;
          }

          message.myBytes = reader.bytes();
          continue;
        case 11:
          if (tag !== 90) {
            break;
          }

          const entry11 = CommonMessage_MyMapEntry.decode(reader, reader.uint32());
          if (entry11.value !== undefined) {
            message.myMap[entry11.key] = entry11.value;
          }
          continue;
        case 12:
          if (tag !== 98) {
            break;
          }

          message.myTimestamp = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 13:
          if (tag !== 106) {
            break;
          }

          message.myAny = Any.decode(reader, reader.uint32());
          continue;
        case 14:
          if (tag !== 114) {
            break;
          }

          message.myDuration = Duration.decode(reader, reader.uint32());
          continue;
        case 15:
          if (tag !== 122) {
            break;
          }

          message.callStack.push(reader.string());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): CommonMessage {
    return {
      myString: isSet(object.myString) ? String(object.myString) : "",
      myInt32: isSet(object.myInt32) ? Number(object.myInt32) : 0,
      myFloat: isSet(object.myFloat) ? Number(object.myFloat) : 0,
      myBool: isSet(object.myBool) ? Boolean(object.myBool) : false,
      myEnum: isSet(object.myEnum) ? myEnumFromJSON(object.myEnum) : 0,
      myNumbers: Array.isArray(object?.myNumbers) ? object.myNumbers.map((e: any) => Number(e)) : [],
      innerMessage: isSet(object.innerMessage) ? InnerMessage.fromJSON(object.innerMessage) : undefined,
      myStringField: isSet(object.myStringField) ? String(object.myStringField) : undefined,
      myInt32Field: isSet(object.myInt32Field) ? Number(object.myInt32Field) : undefined,
      myBytes: isSet(object.myBytes) ? bytesFromBase64(object.myBytes) : new Uint8Array(0),
      myMap: isObject(object.myMap)
        ? Object.entries(object.myMap).reduce<{ [key: string]: number }>((acc, [key, value]) => {
          acc[key] = Number(value);
          return acc;
        }, {})
        : {},
      myTimestamp: isSet(object.myTimestamp) ? fromJsonTimestamp(object.myTimestamp) : undefined,
      myAny: isSet(object.myAny) ? Any.fromJSON(object.myAny) : undefined,
      myDuration: isSet(object.myDuration) ? Duration.fromJSON(object.myDuration) : undefined,
      callStack: Array.isArray(object?.callStack) ? object.callStack.map((e: any) => String(e)) : [],
    };
  },

  toJSON(message: CommonMessage): unknown {
    const obj: any = {};
    message.myString !== undefined && (obj.myString = message.myString);
    message.myInt32 !== undefined && (obj.myInt32 = Math.round(message.myInt32));
    message.myFloat !== undefined && (obj.myFloat = message.myFloat);
    message.myBool !== undefined && (obj.myBool = message.myBool);
    message.myEnum !== undefined && (obj.myEnum = myEnumToJSON(message.myEnum));
    if (message.myNumbers) {
      obj.myNumbers = message.myNumbers.map((e) => Math.round(e));
    } else {
      obj.myNumbers = [];
    }
    message.innerMessage !== undefined &&
      (obj.innerMessage = message.innerMessage ? InnerMessage.toJSON(message.innerMessage) : undefined);
    message.myStringField !== undefined && (obj.myStringField = message.myStringField);
    message.myInt32Field !== undefined && (obj.myInt32Field = Math.round(message.myInt32Field));
    message.myBytes !== undefined &&
      (obj.myBytes = base64FromBytes(message.myBytes !== undefined ? message.myBytes : new Uint8Array(0)));
    obj.myMap = {};
    if (message.myMap) {
      Object.entries(message.myMap).forEach(([k, v]) => {
        obj.myMap[k] = Math.round(v);
      });
    }
    message.myTimestamp !== undefined && (obj.myTimestamp = message.myTimestamp.toISOString());
    message.myAny !== undefined && (obj.myAny = message.myAny ? Any.toJSON(message.myAny) : undefined);
    message.myDuration !== undefined &&
      (obj.myDuration = message.myDuration ? Duration.toJSON(message.myDuration) : undefined);
    if (message.callStack) {
      obj.callStack = message.callStack.map((e) => e);
    } else {
      obj.callStack = [];
    }
    return obj;
  },

  create<I extends Exact<DeepPartial<CommonMessage>, I>>(base?: I): CommonMessage {
    return CommonMessage.fromPartial(base ?? {});
  },

  fromPartial<I extends Exact<DeepPartial<CommonMessage>, I>>(object: I): CommonMessage {
    const message = createBaseCommonMessage();
    message.myString = object.myString ?? "";
    message.myInt32 = object.myInt32 ?? 0;
    message.myFloat = object.myFloat ?? 0;
    message.myBool = object.myBool ?? false;
    message.myEnum = object.myEnum ?? 0;
    message.myNumbers = object.myNumbers?.map((e) => e) || [];
    message.innerMessage = (object.innerMessage !== undefined && object.innerMessage !== null)
      ? InnerMessage.fromPartial(object.innerMessage)
      : undefined;
    message.myStringField = object.myStringField ?? undefined;
    message.myInt32Field = object.myInt32Field ?? undefined;
    message.myBytes = object.myBytes ?? new Uint8Array(0);
    message.myMap = Object.entries(object.myMap ?? {}).reduce<{ [key: string]: number }>((acc, [key, value]) => {
      if (value !== undefined) {
        acc[key] = Number(value);
      }
      return acc;
    }, {});
    message.myTimestamp = object.myTimestamp ?? undefined;
    message.myAny = (object.myAny !== undefined && object.myAny !== null) ? Any.fromPartial(object.myAny) : undefined;
    message.myDuration = (object.myDuration !== undefined && object.myDuration !== null)
      ? Duration.fromPartial(object.myDuration)
      : undefined;
    message.callStack = object.callStack?.map((e) => e) || [];
    return message;
  },
};

function createBaseCommonMessage_MyMapEntry(): CommonMessage_MyMapEntry {
  return { key: "", value: 0 };
}

export const CommonMessage_MyMapEntry = {
  encode(message: CommonMessage_MyMapEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== 0) {
      writer.uint32(16).int32(message.value);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): CommonMessage_MyMapEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseCommonMessage_MyMapEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 16) {
            break;
          }

          message.value = reader.int32();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): CommonMessage_MyMapEntry {
    return { key: isSet(object.key) ? String(object.key) : "", value: isSet(object.value) ? Number(object.value) : 0 };
  },

  toJSON(message: CommonMessage_MyMapEntry): unknown {
    const obj: any = {};
    message.key !== undefined && (obj.key = message.key);
    message.value !== undefined && (obj.value = Math.round(message.value));
    return obj;
  },

  create<I extends Exact<DeepPartial<CommonMessage_MyMapEntry>, I>>(base?: I): CommonMessage_MyMapEntry {
    return CommonMessage_MyMapEntry.fromPartial(base ?? {});
  },

  fromPartial<I extends Exact<DeepPartial<CommonMessage_MyMapEntry>, I>>(object: I): CommonMessage_MyMapEntry {
    const message = createBaseCommonMessage_MyMapEntry();
    message.key = object.key ?? "";
    message.value = object.value ?? 0;
    return message;
  },
};

declare var self: any | undefined;
declare var window: any | undefined;
declare var global: any | undefined;
var tsProtoGlobalThis: any = (() => {
  if (typeof globalThis !== "undefined") {
    return globalThis;
  }
  if (typeof self !== "undefined") {
    return self;
  }
  if (typeof window !== "undefined") {
    return window;
  }
  if (typeof global !== "undefined") {
    return global;
  }
  throw "Unable to locate global object";
})();

function bytesFromBase64(b64: string): Uint8Array {
  if (tsProtoGlobalThis.Buffer) {
    return Uint8Array.from(tsProtoGlobalThis.Buffer.from(b64, "base64"));
  } else {
    const bin = tsProtoGlobalThis.atob(b64);
    const arr = new Uint8Array(bin.length);
    for (let i = 0; i < bin.length; ++i) {
      arr[i] = bin.charCodeAt(i);
    }
    return arr;
  }
}

function base64FromBytes(arr: Uint8Array): string {
  if (tsProtoGlobalThis.Buffer) {
    return tsProtoGlobalThis.Buffer.from(arr).toString("base64");
  } else {
    const bin: string[] = [];
    arr.forEach((byte) => {
      bin.push(String.fromCharCode(byte));
    });
    return tsProtoGlobalThis.btoa(bin.join(""));
  }
}

type Builtin = Date | Function | Uint8Array | string | number | boolean | undefined;

export type DeepPartial<T> = T extends Builtin ? T
  : T extends Array<infer U> ? Array<DeepPartial<U>> : T extends ReadonlyArray<infer U> ? ReadonlyArray<DeepPartial<U>>
  : T extends {} ? { [K in keyof T]?: DeepPartial<T[K]> }
  : Partial<T>;

type KeysOfUnion<T> = T extends T ? keyof T : never;
export type Exact<P, I extends P> = P extends Builtin ? P
  : P & { [K in keyof P]: Exact<P[K], I[K]> } & { [K in Exclude<keyof I, KeysOfUnion<P>>]: never };

function toTimestamp(date: Date): Timestamp {
  const seconds = date.getTime() / 1_000;
  const nanos = (date.getTime() % 1_000) * 1_000_000;
  return { seconds, nanos };
}

function fromTimestamp(t: Timestamp): Date {
  let millis = (t.seconds || 0) * 1_000;
  millis += (t.nanos || 0) / 1_000_000;
  return new Date(millis);
}

function fromJsonTimestamp(o: any): Date {
  if (o instanceof Date) {
    return o;
  } else if (typeof o === "string") {
    return new Date(o);
  } else {
    return fromTimestamp(Timestamp.fromJSON(o));
  }
}

function isObject(value: any): boolean {
  return typeof value === "object" && value !== null;
}

function isSet(value: any): boolean {
  return value !== null && value !== undefined;
}

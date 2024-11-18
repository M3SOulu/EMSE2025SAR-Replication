/* eslint-disable */
import {
  CallOptions,
  ChannelCredentials,
  Client,
  ClientOptions,
  ClientUnaryCall,
  handleUnaryCall,
  makeGenericClientConstructor,
  Metadata,
  ServiceError,
  UntypedServiceImplementation,
} from "@grpc/grpc-js";
import { CommonMessage } from "./message";

export const protobufPackage = "protos";

export type Ts_CService = typeof Ts_CService;
export const Ts_CService = {
  tsC1: {
    path: "/protos.Ts_C/Ts_C_1",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsC2: {
    path: "/protos.Ts_C/Ts_C_2",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsC3: {
    path: "/protos.Ts_C/Ts_C_3",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
} as const;

export interface Ts_CServer extends UntypedServiceImplementation {
  tsC1: handleUnaryCall<CommonMessage, CommonMessage>;
  tsC2: handleUnaryCall<CommonMessage, CommonMessage>;
  tsC3: handleUnaryCall<CommonMessage, CommonMessage>;
}

export interface Ts_CClient extends Client {
  tsC1(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC1(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC1(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC2(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC2(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC2(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC3(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC3(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsC3(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
}

export const Ts_CClient = makeGenericClientConstructor(Ts_CService, "protos.Ts_C") as unknown as {
  new (address: string, credentials: ChannelCredentials, options?: Partial<ClientOptions>): Ts_CClient;
  service: typeof Ts_CService;
};

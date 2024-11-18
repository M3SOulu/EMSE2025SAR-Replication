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

export type Ts_BService = typeof Ts_BService;
export const Ts_BService = {
  tsB1: {
    path: "/protos.Ts_B/Ts_B_1",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsB2: {
    path: "/protos.Ts_B/Ts_B_2",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsB3: {
    path: "/protos.Ts_B/Ts_B_3",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
} as const;

export interface Ts_BServer extends UntypedServiceImplementation {
  tsB1: handleUnaryCall<CommonMessage, CommonMessage>;
  tsB2: handleUnaryCall<CommonMessage, CommonMessage>;
  tsB3: handleUnaryCall<CommonMessage, CommonMessage>;
}

export interface Ts_BClient extends Client {
  tsB1(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB1(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB1(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB2(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB2(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB2(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB3(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB3(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsB3(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
}

export const Ts_BClient = makeGenericClientConstructor(Ts_BService, "protos.Ts_B") as unknown as {
  new (address: string, credentials: ChannelCredentials, options?: Partial<ClientOptions>): Ts_BClient;
  service: typeof Ts_BService;
};

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

export type Ts_AService = typeof Ts_AService;
export const Ts_AService = {
  tsA1: {
    path: "/protos.Ts_A/Ts_A_1",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsA2: {
    path: "/protos.Ts_A/Ts_A_2",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  tsA3: {
    path: "/protos.Ts_A/Ts_A_3",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
} as const;

export interface Ts_AServer extends UntypedServiceImplementation {
  tsA1: handleUnaryCall<CommonMessage, CommonMessage>;
  tsA2: handleUnaryCall<CommonMessage, CommonMessage>;
  tsA3: handleUnaryCall<CommonMessage, CommonMessage>;
}

export interface Ts_AClient extends Client {
  tsA1(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA1(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA1(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA2(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA2(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA2(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA3(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA3(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  tsA3(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
}

export const Ts_AClient = makeGenericClientConstructor(Ts_AService, "protos.Ts_A") as unknown as {
  new (address: string, credentials: ChannelCredentials, options?: Partial<ClientOptions>): Ts_AClient;
  service: typeof Ts_AService;
};

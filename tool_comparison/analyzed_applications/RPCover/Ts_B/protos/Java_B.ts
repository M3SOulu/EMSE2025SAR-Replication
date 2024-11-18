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

export type Java_BService = typeof Java_BService;
export const Java_BService = {
  javaB1: {
    path: "/protos.Java_B/Java_B_1",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  javaB2: {
    path: "/protos.Java_B/Java_B_2",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  javaB3: {
    path: "/protos.Java_B/Java_B_3",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
} as const;

export interface Java_BServer extends UntypedServiceImplementation {
  javaB1: handleUnaryCall<CommonMessage, CommonMessage>;
  javaB2: handleUnaryCall<CommonMessage, CommonMessage>;
  javaB3: handleUnaryCall<CommonMessage, CommonMessage>;
}

export interface Java_BClient extends Client {
  javaB1(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB1(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB1(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB2(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB2(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB2(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB3(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB3(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  javaB3(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
}

export const Java_BClient = makeGenericClientConstructor(Java_BService, "protos.Java_B") as unknown as {
  new (address: string, credentials: ChannelCredentials, options?: Partial<ClientOptions>): Java_BClient;
  service: typeof Java_BService;
};

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

export type Python_BService = typeof Python_BService;
export const Python_BService = {
  pythonB1: {
    path: "/protos.Python_B/Python_B_1",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  pythonB2: {
    path: "/protos.Python_B/Python_B_2",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
  pythonB3: {
    path: "/protos.Python_B/Python_B_3",
    requestStream: false,
    responseStream: false,
    requestSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    requestDeserialize: (value: Buffer) => CommonMessage.decode(value),
    responseSerialize: (value: CommonMessage) => Buffer.from(CommonMessage.encode(value).finish()),
    responseDeserialize: (value: Buffer) => CommonMessage.decode(value),
  },
} as const;

export interface Python_BServer extends UntypedServiceImplementation {
  pythonB1: handleUnaryCall<CommonMessage, CommonMessage>;
  pythonB2: handleUnaryCall<CommonMessage, CommonMessage>;
  pythonB3: handleUnaryCall<CommonMessage, CommonMessage>;
}

export interface Python_BClient extends Client {
  pythonB1(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB1(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB1(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB2(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB2(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB2(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB3(
    request: CommonMessage,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB3(
    request: CommonMessage,
    metadata: Metadata,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
  pythonB3(
    request: CommonMessage,
    metadata: Metadata,
    options: Partial<CallOptions>,
    callback: (error: ServiceError | null, response: CommonMessage) => void,
  ): ClientUnaryCall;
}

export const Python_BClient = makeGenericClientConstructor(Python_BService, "protos.Python_B") as unknown as {
  new (address: string, credentials: ChannelCredentials, options?: Partial<ClientOptions>): Python_BClient;
  service: typeof Python_BService;
};

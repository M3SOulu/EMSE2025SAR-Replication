import {Ts_AServer,Ts_AService} from "./protos/Ts_A";
import {Ts_BClient} from "./protos/Ts_B";
import {Ts_CClient} from "./protos/Ts_C";
import {Cpp_AClient} from "./protos/Cpp_A";
import {Cpp_BClient} from "./protos/Cpp_B";
import {Java_CClient} from "./protos/Java_C";
import {Server, ServerCredentials,sendUnaryData, ServerUnaryCall, credentials} from '@grpc/grpc-js';
import { CommonMessage, MyEnum } from "./protos/message";

function getServer(): Ts_AServer {
    function tsA1(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_A_1'
        console.log(name+" called by "+call.request.myString)
        let stk = call.request.callStack
        stk.push(name)

        const req: CommonMessage = {
            myString: name,
            callStack: stk,
            myInt32: 0,
            myFloat: 0.0,
            myBool: false,
            myEnum: MyEnum.ENUM_VALUE_1, // 使用枚举的默认值
            myNumbers: [],
            innerMessage: undefined,
            myStringField: undefined,
            myInt32Field: undefined,
            myBytes: new Uint8Array(),
            myMap: {},
            myTimestamp: undefined,
            myAny: undefined,
            myDuration: undefined,
          };

        tsA2(call, callback);
        let tsB = new Ts_BClient("ts_b:8080",credentials.createInsecure());
        tsB.tsB3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let tsC = new Ts_CClient("ts_c:8080",credentials.createInsecure());
        tsC.tsC2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let cppA = new Cpp_AClient("cpp_a:8080",credentials.createInsecure());
        cppA.cppA2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop();
        req.callStack = stk;
        callback(null, req);
    }
    
    function tsA2(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_A_2'
        console.log(name+" called by "+call.request.myString)
        let stk = call.request.callStack
        stk.push(name)

        let req: CommonMessage = {
            myString: name,
            callStack: stk,
            myInt32: 0,
            myFloat: 0.0,
            myBool: false,
            myEnum: MyEnum.ENUM_VALUE_1, // 使用枚举的默认值
            myNumbers: [],
            innerMessage: undefined,
            myStringField: undefined,
            myInt32Field: undefined,
            myBytes: new Uint8Array(),
            myMap: {},
            myTimestamp: undefined,
            myAny: undefined,
            myDuration: undefined,
          };
    
        tsA3(call, callback)
    
        let cppB = new Cpp_BClient("cpp_b:8080",credentials.createInsecure());
        cppB.cppB2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let javaC = new Java_CClient("java_c:8080",credentials.createInsecure());
        javaC.javaC2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    
    function tsA3(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_A_3'
        console.log(name+" called by "+call.request.myString)
        let stk = call.request.callStack
        stk.push(name)
        let req:CommonMessage ={
            myString: name,
            callStack: stk,
            myInt32: 0,
            myFloat: 0.0,
            myBool: false,
            myEnum: MyEnum.ENUM_VALUE_1, // 使用枚举的默认值
            myNumbers: [],
            innerMessage: undefined,
            myStringField: undefined,
            myInt32Field: undefined,
            myBytes: new Uint8Array(),
            myMap: {},
            myTimestamp: undefined,
            myAny: undefined,
            myDuration: undefined,
          };
    
        tsA1(call, callback)
    
        let tsB = new Ts_BClient("ts_b:8080",credentials.createInsecure());
        tsB.tsB3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let tsC = new Ts_CClient("ts_c:8080",credentials.createInsecure());
        tsC.tsC3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    return {
        tsA1,
        tsA2,
        tsA3
    };
}
function main() {
    var server = new Server();
    server.addService(Ts_AService,  getServer());
    server.bindAsync('0.0.0.0:8080', ServerCredentials.createInsecure(), () => {
        server.start();
    });
}
console.log("ts_a server start")
main();
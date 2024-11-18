import {Ts_BServer,Ts_BService} from "./protos/Ts_B";
import {Ts_CClient} from "./protos/Ts_C";
import {Cpp_AClient} from "./protos/Cpp_A";
import {Cpp_BClient} from "./protos/Cpp_B";
import {Java_AClient} from "./protos/Java_A";
import {Java_BClient} from "./protos/Java_B";
import {Python_AClient} from "./protos/Python_A";
import {Server, ServerCredentials,sendUnaryData, ServerUnaryCall, credentials} from '@grpc/grpc-js';
import { CommonMessage, MyEnum } from "./protos/message";

function getServer(): Ts_BServer {
    function tsB1(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_B_1'
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

        let Python_A = new Python_AClient("python_a:8080",credentials.createInsecure());
        Python_A.pythonA2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let javab = new Java_BClient("ts_c:8080",credentials.createInsecure());
        javab.javaB2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop();
        req.callStack = stk;
        callback(null, req);
    }
    
    function tsB2(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_B_2'
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
    
        let cppA = new Cpp_AClient("cpp_a:8080",credentials.createInsecure());
        cppA.cppA2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
        let cppB = new Cpp_BClient("cpp_b:8080",credentials.createInsecure());
        cppB.cppB3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    
    function tsB3(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_B_3'
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
    
    
        let cppb = new Cpp_BClient("ts_b:8080",credentials.createInsecure());
        cppb.cppB3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        let javaa = new Java_AClient("ts_c:8080",credentials.createInsecure());
        javaa.javaA2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    return {
        tsB1,
        tsB2,
        tsB3
    };
}
function main() {
    var server = new Server();
    server.addService(Ts_BService,  getServer());
    server.bindAsync('0.0.0.0:8080', ServerCredentials.createInsecure(), () => {
        server.start();
    });
}
console.log("ts_b server start")
main();
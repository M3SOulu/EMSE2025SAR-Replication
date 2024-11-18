import {Ts_CServer,Ts_CService} from "./protos/Ts_C";
import {Python_BClient} from "./protos/Python_B";
import {Go_BClient} from "./protos/Go_B";
import {Server, ServerCredentials,sendUnaryData, ServerUnaryCall, credentials} from '@grpc/grpc-js';
import { CommonMessage, MyEnum } from "./protos/message";
import { Java_CClient } from "../Ts_A/protos/Java_C";

function getServer(): Ts_CServer {
    function tsC1(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_C_1'
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

        let gob = new Go_BClient("go_b:8080",credentials.createInsecure());
        gob.goB2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
        gob.goB3(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop();
        req.callStack = stk;
        callback(null, req);
    }
    
    function tsC2(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_C_2'
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
    
        tsC2(call, callback);
        let javac = new Java_CClient("java_c:8080",credentials.createInsecure());
        javac.javaC2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    
    function tsC3(call:ServerUnaryCall<CommonMessage, CommonMessage>, callback:sendUnaryData<CommonMessage>):void {
        let name = 'ts_C_3'
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
    
    
        let pythonb = new Python_BClient("python_b:8080",credentials.createInsecure());
        pythonb.pythonB2(req, function (err, response:CommonMessage) {
            console.log('get return:', response.myString);
        });
    
        stk.pop()
        req.callStack = stk
        callback(null, req);
    }
    return {
        tsC1,
        tsC2,
        tsC3
    };
}
function main() {
    var server = new Server();
    server.addService(Ts_CService,  getServer());
    server.bindAsync('0.0.0.0:8080', ServerCredentials.createInsecure(), () => {
        server.start();
    });
}
console.log("ts_c server start")
main();
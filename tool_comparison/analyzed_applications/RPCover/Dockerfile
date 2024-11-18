FROM debian:unstable

RUN rm /etc/apt/sources.list.d/debian.sources && echo "deb http://mirrors.ustc.edu.cn/debian/ sid main contrib" >/etc/apt/sources.list && apt update && apt install apt-transport-https curl gnupg -y && curl -fsSL https://bazel.build/bazel-release.pub.gpg | gpg --dearmor >bazel-archive-keyring.gpg && mv bazel-archive-keyring.gpg /usr/share/keyrings && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/bazel-archive-keyring.gpg] https://storage.googleapis.com/bazel-apt stable jdk1.8" | tee /etc/apt/sources.list.d/bazel.list
RUN apt update && apt install wget build-essential ninja-build cmake golang gcc clang libgrpc++-dev libgrpc-dev protobuf-compiler-grpc protobuf-compiler python3 python-is-python3 python3-pip pipx openjdk-11-jdk bazel bazel-5.3.0 bazel-6.1.2 npm openjdk-17-jdk time maven -y
RUN npm install -g @sourcegraph/scip-python --registry=https://registry.npm.taobao.org && npm install -g @sourcegraph/scip-typescript --registry=https://registry.npm.taobao.org && npm install -g @sourcegraph/lsif-tsc --registry=https://registry.npm.taobao.org
COPY third_party /opt/third_party/
COPY . /opt/RPCoverBenchmark
WORKDIR /opt/RPCoverBenchmark
RUN python -m venv venv
ENV PATH="/opt/third_party/binaries:/opt/RPCoverBenchmark/venv/bin:${PATH}"
RUN /opt/RPCoverBenchmark/venv/bin/pip install -i https://mirrors.ustc.edu.cn/pypi/web/simple -r requirements.txt
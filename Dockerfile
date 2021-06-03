FROM maven AS maven_builder
COPY ./ /
WORKDIR /
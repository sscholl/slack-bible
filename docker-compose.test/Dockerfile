FROM ubuntu:trusty

RUN apt-get update && apt-get install -yq curl jq mysql-client  && apt-get clean

WORKDIR /app

ADD test.sh /app/test.sh

CMD ["bash", "test.sh"]
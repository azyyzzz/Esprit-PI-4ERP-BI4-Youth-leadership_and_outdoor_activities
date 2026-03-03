FROM apache/airflow:2.9.3

USER root

RUN apt-get update \
  && apt-get install -y --no-install-recommends openjdk-17-jre-headless ca-certificates socat \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

COPY entrypoint-wrapper.sh /entrypoint-wrapper.sh
RUN chmod +x /entrypoint-wrapper.sh

USER airflow
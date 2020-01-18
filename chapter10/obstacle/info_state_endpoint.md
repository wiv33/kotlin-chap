## Actuator 관련 문서
[Spring-boot-docs](https://docs.spring.io/spring-boot)

### application.yml 에 설정한 속성
* health: 애플리케이션 상태 정보를 자세하게 표시한다.
* metrics: 현재 애플리케이션의 측정 항목 정보를 표시한다.
* trace: 추적 정보를 표시한다. (default - HTTP 요청의 마지막 100개)

## 스프링 부트에서 health indicator를 통해 자동 구성하는 항목
* ***Cassandra***HealthIndicator: 카산드라 데이터베이스가 작동 중인지 확인
* ***DiskSpace***HealthIndicator: ***디스크 공간 부족***을 검사
* ***DataSource***HealthIndicator: DataSource 연결을 얻을 수 있는지 확인
* ***Elasticsearch***HealthIndicator: ***일래스틱서치 클러스터***가 작동 중인지 확인
* ***Jms***HealthIndicator: JMS 브로커가 작동 중인지 확인
* ***Mail***HealthIndicator: 메일 서버가 작동하는지 검사
* ***Mongo***HealthIndicator: 몽고 DB가 작동 중인지 확인
* ***Neo4j***HealthIndicator: Neo4j 서버가 작동 중인지 확인
* ***Rabbit***HealthIndicator: Rabbit 서버가 작동 중인지 확인
* ***Redis***HealthIndicator: Redis 서버가 작동 중인지 확인
* ***Solr***HealthIndicator: Solr 서버가 작동 중인지 확인
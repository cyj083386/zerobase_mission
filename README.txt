1. WIFIproject1 폴더 : 프로젝트 소스

1.1 'webapp' 폴더 : jsp 파일 폴더
1.1.1 home.jsp : [와이파이 정보 구하기] 초기화면(근처 WIFI 정보보기 실행전)
1.1.2 home2.jsp : [와이파이 정보 구하기] 화면(근처 WIFI 정보보기 실행후)
1.1.3 history.jsp : [위치 히스토리 목록] 화면
1.1.4 history2.jsp : [위치 히스토리 목록] 화면(삭제시 재로드)
1.1.5 load-wifi.jsp : [n개의 WIFI 정보를 정상적으로 저장하였습니다.] 화면

1.2 'db' 폴더 : java 파일 모음으로 jdbc 구현한 폴더
1.2.1 Service.java : 필요한 sql 처리 구현한 파일 
1.2.2 WIFIHistory.java : HISTORY 테이블용 DTO
1.2.3 APIExp.java : 공공 API 처리용 explorer
1.2.4 WIFITable.java : WIFITable용 DTO

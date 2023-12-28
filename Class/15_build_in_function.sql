-- 1. 문자열 관련함수
SELECT ASCII('A'), CHAR(97);

-- 영어, 숫자, 특수기호 제외 한 문자 당 3바이트 할당
SELECT BIT_LENGTH('한글')
	  , CHAR_LENGTH('한글')
	  , LENGTH('한글');

-- CONCAT(문자열1, 문자열2, ...), CONCAT_WS(구분자, 문자열1, 문자열2)
SELECT CONCAT('nice', 'to', 'meet', 'u!');
SELECT CONCAT_WS(' ', 'nice', 'to', 'meet', 'u!');
SELECT CONCAT(CAST(menu_price AS CHAR), '원') FROM tbl_menu;

-- ELT(위치, 문자열1, 문자열2, ...), FIELD(찾을 문자열, 문자열1, 문자열2, ...),
-- FIND_IN_SET(찾을 문자열, 문자열 리스트), INSTR(기준 문자열, 부분 문자열),
-- LOCATE(부분 문자열, 기준 문자열)
SELECT 
		 ELT(2, '축구', '야구', '농구')
	  , FIELD('축구', '야구', '농구', '축구')
	  , FIND_IN_SET('축구', '야구,농구,축구')
	  , INSTR('축구농구야구', '농구')
	  , LOCATE('야구', '축구농구야구');  -- INSTR과 LOCATE는 서로 인자가 반대
	  
-- INSERT(기준 문자열, 위치, 삭제할 문자열 길이, 삽입할 문자열)
SELECT INSERT('나와라 피카츄!', 5, 1, '꼬부기');

-- LEFT(문자열, 길이), RIGHT(문자열, 길이)
SELECT LEFT('Hello World!', 5), RIGHT('Nice shot!', 5);

-- UPPER(문자열), LOWER(문자열)
SELECT UPPER('Hello World!'), LOWER('Hello World!');

-- LPAD(문자열, 길이, 채울 문자열), RPAD(문자열, 길이, 채울 문자열)
SELECT LPAD('왼쪽', 10, '/n'), RPAD('오른쪽', 10, '#');

-- LTRIM(문자열), RTIRM(문자열), TRIM(문자열)
SELECT LTRIM('       왼쪽        '), RTRIM('        오른쪽       ');

SELECT 
		 TRIM('           중앙          ')
	  , TRIM(BOTH '@' FROM '@@@@    중앙   @@@@')
	  , TRIM(LEADING '@' FROM '@@@@    중앙   @@@@')
	  , TRIM(TRAILING '@' FROM '@@@@    중앙   @@@@');

SELECT CONCAT(menu_name, '의 가격은 ', menu_price, '원 입니다.') FROM tbl_menu;

-- FORMAT(숫자, 소수점 자릿수)
SELECT FORMAT(121212132122545, 3);

-- BIN(숫자), OCT(숫자), HEX(숫자)
SELECT BIN(65), OCT(65), HEX(65);

-- REPEAT(문자열, 횟수)
SELECT REPEAT('재미져 ', 5);

-- REPLACE(문자열, 찾을 문자열, 바꿀 문자열)
SELECT REPLACE('마리아DB', '마리아', 'Maria');

-- REVERSE(문자열)
SELECT REVERSE('happiness');

-- SPACE(길이)
SELECT CONCAT('제 포켓몬은', SPACE(3), '이고, 속성은', SPACE(6), '입니다.');

-- SUBSTRING(문자열, 시작위치, 길이)
SELECT SUBSTRING('열심히 db공부를 해봅시다.', 5, 4);

-- SUBSTRING_INDEX(문자열, 구분자, 횟수)
SELECT 
		 SUBSTRING_INDEX('010-123-1234', '-', 2)
	  , SUBSTRING_INDEX('010-123-1234', '-', -1);
	  



-- 2.숫자 관련함수
-- ABS(숫자)
SELECT ABS(-123);

-- CEILING(숫자), FLOOR(숫자), ROUND(숫자)
SELECT CEILING(1234.56), FLOOR(1234.56), ROUND(1234.56);

-- CONV(숫자, 원래 진수, 변환할 진수)
SELECT CONV('A', 16, 10), CONV('A', 16, 2);

-- MOD(숫자1, 숫자2)
SELECT MOD(10,3), 10 % 3;

-- POW(숫자1, 숫자2), SQRT(숫자)
SELECT POW(3, 2), SQRT(81);

-- RAND()
-- FLOOR(RAND() * 생성할 난수 갯수 + 난수의 초기 값)
SELECT FLOOR(RAND() * 29 + 5), FLOOR(RAND() * 29) + 5; -- 5 ~ 33 사이 난수

-- SIGN(숫자)
SELECT SIGN(10.1), SIGN(0), SIGN(-1.1);

-- TRUNCATE(숫자, 정수)
SELECT TRUNCATE(12345.12345, 2), TRUNCATE(12345.12345, -2);




-- 3. 날짜 및 시간 관련함수
-- ADDDATE(날짜, 차이), SUBDATE(날짜, 차이)
SELECT 
		 ADDDATE('2023-05-31', INTERVAL 30 DAY)
	  , ADDDATE('2023-05-31', 30)
	  , SUBDATE('2023-05-31', INTERVAL 30 DAY)
	  , SUBDATE('2023-05-31', INTERVAL 30 MONTH);
	  
-- ADDTIME(날짜/시간, 시간), SUBTIME(날짜/시간, 시간)
SELECT 
		 ADDTIME('2023-12-28 10:27:00','1:0:10')
	  , SUBTIME('2023-12-28 10:27:00','1:0:10');

-- CURDATE(), CURTIME(), NOW(), SYSDATE()
SELECT CURDATE(), CURTIME(), NOW(), SYSDATE();
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIME;

-- YEAR(날짜), MONTH(날짜), DAY(날짜), HOUR(시간), MINUTE(시간), SECOND(시간), MICROSECOND(시간)
-- DATE(), TIME()
SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE()), DAY(CAST('2023-12-28' AS DATE));
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURTIME());

-- DATEDIFF(날짜1, 날짜2), TIMEDIFF(날짜1 또는 시간1, 날짜1 또는 시간2)
SELECT DATEDIFF('2024-06-14', '2023-12-28'), TIMEDIFF('18:00:00', CURTIME());

-- DAYOFWEEK(날짜), MONTHNAME(날짜), DAYOFYEAR(날짜)
SELECT DAYOFWEEK(CURDATE()), MONTHNAME(CURDATE()), DAYOFYEAR(CURDATE());

-- LAST_DAY(날짜)
SELECT LAST_DAY('20230201');

-- MAKEDATE(연도, 지난 날)
SELECT MAKEDATE(2023, 35);

-- MAKETIME(시간, 분, 초)
SELECT MAKETIME(17, 50, 01);

-- QUARTER(날짜)
SELECT QUARTER('2023-12-28');

-- TIME_TO_SEC(시간)
SELECT TIME_TO_SEC(CURTIME());
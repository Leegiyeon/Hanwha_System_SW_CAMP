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


-- 2.숫자 관련함수

-- 3. 날짜 및 시간 관련함수
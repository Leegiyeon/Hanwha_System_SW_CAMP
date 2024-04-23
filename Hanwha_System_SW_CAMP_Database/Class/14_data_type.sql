-- 명시적 형변환
SELECT AVG(menu_price) FROM tbl_menu;

-- 1) 숫자 > 숫자
-- 소수점에서 반올림해 정수로 변환
SELECT CAST(AVG(menu_price) AS UNSIGNED INTEGER) AS '평균 가격' FROM tbl_menu;

-- 소수점 이하 한자리까지 변환
SELECT CAST(AVG(menu_price) AS FLOAT) AS '평균 가격' FROM tbl_menu;

-- 소수점 이하 12자리까지 변환
SELECT CAST(AVG(menu_price) AS DOUBLE) AS '평균 가격' FROM tbl_menu;


-- 2) 문자 > 날짜
-- 2023년 12월 27일을 DATE형으로 변환
SELECT CAST('2023$12$27' AS DATE);
SELECT CONVERT('2023/12/27', DATE);
SELECT CONVERT('2023-12-27', DATE);
SELECT CONVERT('2023?12?27', DATE);
SELECT CONVERT('2023!12!27', DATE);


-- 3) 숫자 > 문자
SELECT CONCAT(CAST(1000 AS CHAR), '원');
SELECT 1000 + '원'; -- 좋지 않은 방법


-- 4) 낳짜 > 문자
SELECT hire_date FROM employee; -- date형
SELECT CAST(hire_date AS CHAR)FROM employee; -- 문자형

-- ----------------------------------------------------------------------------
-- 암시적 형변환
-- 연산자 사용 시 자동 형변환이 되는데 주의
SELECT 1 +'2';
SELECT '1' +'2';

-- 모든 문자는 산술연산 또는 비교연산을 만나면 0이 된다.
SELECT CONCAT('1', '2');
SELECT '안녕' + '하세요';


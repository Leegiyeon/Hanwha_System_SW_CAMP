-- 조회 6가지 절을 모두 활용한 예제

-- select: group by 절에서 group을 묶는 조건으로 활용한 컬럼만 조회
-- from: 테이블 또는 join을 활용한 result set을 작성한다.
-- where: from절의 각 행마다 적용될 조건을 작성한다.
-- group by: where절까지 만족하는 행들에 대해 그룹이 될 컬럼을 작성한다.
-- having: 그룹별로 적용할 조건을 group by에서 작성한 컬럼 또는 그룹함수를 통해 조회한다.
-- order by: 제일 마지막에 해석되며 select의 결과의 순번, 별칭, 컬럼명 등으로 오름차순 내림차순 한다.

SELECT -- 4 아래 항목을 
    	 category_code
 	  , COUNT(*)
  	  , SUM(menu_price)
 	  , AVG(menu_price)
  FROM tbl_menu -- 1 여기에 있는
 WHERE category_code IS NOT NULL -- 2 이조건을 만족하는
 GROUP BY category_code -- 3 이 조건으로 묶인
 ORDER BY 2;
  
  -- ----------------------------------------------------
SELECT -- 5 아래 항목을 
 		 category_code
 	  , COUNT(*)
 	  , SUM(menu_price)
 	  , AVG(menu_price)
  FROM tbl_menu -- 1 여기에 있는
 WHERE category_code IS NOT NULL -- 2 이 조건을 만족하는
 GROUP BY category_code -- 3 이 조건으로 묶인
HAVING SUM(menu_price) >= 24000 -- 4 그중에서 이 조건을 만족하는
 ORDER BY 2;
 -- -----------------------------------------------------
SELECT -- 5 아래 항목을 
 		 category_code
 	  , COUNT(*) -- 모든 행 갯수 세기
 	  , COUNT(category_code) -- category_code가 NULL인 행을 제외한 갯수
 	  , SUM(menu_price)
 	  , AVG(menu_price)
  FROM tbl_menu -- 1 여기에 있는
 WHERE category_code IS NOT NULL -- 2 이 조건을 만족하는
 GROUP BY category_code -- 3 이 조건으로 묶인
HAVING SUM(menu_price) >= 24000 -- 4 그중에서 이 조건을 만족하는
 ORDER BY 2; 
 
-- -------------------------------------------------------
SELECT 
		 COUNT(*)
	  , COUNT(a.menu_name)
  FROM tbl_menu a
 RIGHT JOIN tbl_category b ON (a.category_code = b.category_code);
 
-- -------------------------------------------------------
-- 함수의 종류
-- 단일 행 함수: NVL 또는 IFNULL과 같이 단일 행마다 적용되어 행의 갯수만큼 결과가 나오는 경우
-- 그룹 함수: COUNT, SUM, AVG와 같이 그룹마다 적용되어 그룹의 갯수만큼 결과가 나오는 경우
--            (단, GROUP BY 절이 없는 조회는 그룹함수의 결과가 단일 행(행 하나)이다.)  

-- -------------------------------------------------------
-- ROLL UP
-- 중간 합계 및 최종 합계 도출
-- GROUP BY에서 두개 이상의 컬럼으로 그룹 형성 시

SELECT 
		 menu_price
	  , category_code
	  , SUM(menu_price)
  FROM tbl_menu
 GROUP BY menu_price, category_code
  WITH ROLLUP;
  
-- -------------------------------------------------------
CREATE TABLE sales (
   code INT AUTO_INCREMENT,
   year VARCHAR(4),
   month VARCHAR(2),
   product VARCHAR(50),
   amount DECIMAL(10,2),
   PRIMARY KEY(code)
);

INSERT
  INTO sales 
(
  code
, YEAR
, MONTH
, product
, amount
) 
VALUES
(
  null
, '2023'
, LPAD('1', 2, '0')
, 'Product A'
, 1000.00
),
(
  null, '2023', LPAD('1', 2, '0') -- = '01'
, 'Product B', 1500.00
),
(
  null, '2023', LPAD('2', 2, '0')
  , 'Product A', 2000.00
),
(
  null, '2023', LPAD('2', 2, '0')
  , 'Product B', 2500.00
),
(
  null, '2023', LPAD('3', 2, '0')
  , 'Product A', 1200.00
),
(
null, '2024', LPAD('3', 2, '0')
, 'Product B', 1700.00
);ㄴ

-- 연, 월, 상품면을 모두 하나의 그룹으로 묶어 
-- 연, 월 중간 합계 및 전체 합계를 ROLLUP으로 구해보자
SELECT
       year
	  , month
	  , product
	  , SUM(amount) AS total_sales
  FROM sales
 GROUP BY year, month, product 
  WITH ROLLUP;
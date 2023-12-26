SELECT 
		 *
  FROM tbl_menu
  JOIN tbl_category ON tbl_menu.category_code = tbl_category.category_code;

--  JOIN할 두 테이블 조회
SELECT
		 *
  FROM tbl_menu;
  
SELECT 
		 *
  FROM tbl_category;

-- 메뉴 명과 카테고리명만 조회
SELECT
		 *
  FROM tbl_menu
  JOIN tbl_category ON (tbl_menu.category_code = tbl_category.category_code);
  
--   테이블 명에도 별칭(alias) 붙일 수 있다.

SELECT
		 *
  FROM tbl_menu a
  JOIN tbl_category b ON(a.category_code = b.category_code);
  
-- -------------------------
-- 두 테이블에 같은 컬럼명이 있는 상태에서 주의 할 것
SELECT
		 *
  FROM tbl_menu a
  JOIN tbl_category b ON(category_code = category_code); -- 애매해서 에러남
--   두테이블이 동일한 컬럼이 존재할 때 별칭 필수

SELECT 
		 a.category_code
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code);
  
SELECT 
		 a.menu_name AS 'a mn'
	  , b.category_name AS 'b cn'
	  , a.category_code AS 'a cc'
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code);
  
  
SELECT 
		 *
  FROM tbl_menu a
 RIGHT JOIN tbl_category b USING (category_code);
 
-- Cross join
 
SELECT
		 *
  FROM tbl_menu a
  JOIN tbl_category b ON (1=1);
  
  
  
SELECT
		 a.category_name
	  , b.category_name
  FROM tbl_category a
  JOIN tbl_category b ON(a.category_code = b.ref_category_code);
  
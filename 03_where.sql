SELECT 
		 menu_name
	  , menu_price
	  , orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'Y';
--  메뉴 테이블에서 주문가능한 메뉴의 이름과 가격을 조회해줘

SELECT
		 menu_name
	  , menu_code
	  , orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'N'
 ORDER BY orderable_status DESC;
 
 
SELECT
		 menu_name AS '만원이상메뉴'
	  , menu_price AS '가격'
  FROM tbl_menu
 WHERE menu_price >= 10000
 ORDER BY menu_price;
 
SELECT 
		 menu_name AS '12000원-10000원 메뉴'
	  , menu_price AS '가격'
  FROM tbl_menu
 WHERE menu_price BETWEEN 10000 AND 12000
 ORDER BY menu_price DESC;
 
 
SELECT 
	    round(avg(menu_price), 0) AS '평균가격'
  FROM tbl_menu
--  WHERE menu_price BETWEEN 5000 AND 10000;

SELECT
       menu_code
     , menu_name
     , menu_price
     , category_code
     , orderable_status
  FROM tbl_menu
 WHERE menu_price > 5000
   AND category_code = 10;
   
   
   
--    ----------------------------

SELECT 
		 menu_name
	  , menu_price
  FROM tbl_menu
 WHERE menu_name not LIKE '%밥%'
 -- --------------------------------
 
SELECT 
 	    menu_name
 	  , menu_price
  FROM tbl_menu
 WHERE category_code = 5
 	 OR category_code = 8
 	 OR category_code = 10;
 
SELECT 
 	    menu_name
 	  , menu_price
  FROM tbl_menu
 WHERE category_code IN (5, 8, 10);	 
 
--  ------------------
SELECT 
		 *
  FROM tbl_category
--  WHERE ref_category_code IS NULL;
 WHERE ref_category_code IS NOT NULL;
SELECT
       menu_code
     , menu_name
     , menu_price
  FROM tbl_menu
 ORDER BY menu_price ASC;	-- ASC는 오름차순
--  ORDER BY menu_price;

SELECT
       menu_code
     , menu_name
     , menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC;	-- DESC는 내림차순
 
--   --------------------------------------------
SELECT 
		 menu_code
	  , menu_name
	  , menu_price
  FROM tbl_menu
 ORDER BY menu_code; 

SELECT
       menu_code -- 1번째
	  , menu_name -- 2번째
     , menu_price -- 3번째
  FROM tbl_menu
 ORDER BY 1; 


SELECT 
		 menu_price AS 'mp'
	  , menu_name AS 'mn'
  FROM tbl_menu
 ORDER BY mp DESC;
 
SELECT
		 menu_price 
	  , menu_name
  FROM tbl_menu
 ORDER BY 1 DESC, 2 ASC;
 -- 가격을 내림차순 한 후, 메뉴이름을 오름차순으로 설정
 
 -- Field
 SELECT FIELD('c', 'b', 'z', 'a');
 -- ---------찾을대상--뒤에서 몇 번째에 있는지
 -- 2번째 이후 인자 중 1번째 인자의 값이 위치하는 값
 
 SELECT
 		 FIELD(orderable_status, 'N', 'Y') -- orderable_status = Y
 	  , orderable_status
 	  , menu_name
 	  , menu_code
  FROM tbl_menu
 ORDER BY orderable_status;
 
SELECT
 		 menu_name
 	  , menu_code
 	  , orderable_status
  FROM tbl_menu
 ORDER BY FIELD(orderable_status, 'Y', 'N') DESC, 1 ASC;
 -- ------------------------------------------------------
 -- null 값에 대한 정렬
SELECT
 		 * 
  FROM tbl_category
 ORDER BY ref_category_code ASC;
 
SELECT
 		 * 
  FROM tbl_category
 ORDER BY ref_category_code DESC;
 
SELECT
 		 * 
  FROM tbl_category
 ORDER BY -ref_category_code ASC;
--  내림차순에서 Null이 처음에 오도록

SELECT
 		 * 
  FROM tbl_category
 ORDER BY -ref_category_code DESC;
 -- 오름차순에서 Null이 나중에 오도록 > DESC를 통해 Null을 나중에 보냄, -로 Null이 아닌 값을 ASC로 바꿈 
 
 

 
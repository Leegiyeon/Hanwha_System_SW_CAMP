SELECT 
		 menu_code
	  , menu_name
	  , menu_price 
  FROM tbl_menu;

DESC tbl_category;
  
SELECT
		 category_code
	  , category_name
	  , ref_category_code	 
  FROM tbl_category;
  
  
SELECT 
		 menu_name
	  , category_name
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code);
  
-- ---------------------------------------------------------------
-- 특수기호가 들어간 별칭은 싱글쿼테이션(')이 반드시 필요하다.
SELECT 7 + 3 합입니다, 10 * 2 '곱';
SELECT NOW() 현재시간;
SELECT CONCAT('유', ' ', '관순') 독립운동가;
-- = select '유 관순'




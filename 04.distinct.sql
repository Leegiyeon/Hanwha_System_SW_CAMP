SELECT 
       DISTINCT category_code
--      , menu_name
  FROM tbl_menu
 ORDER BY category_code;

SELECT 
       DISTINCT ref_category_code
  FROM tbl_category
 ORDER BY 1 DESC;
 
 
SELECT 
       DISTINCT ref_category_code
  FROM tbl_category
 ORDER BY DISTINCT ref_category_code DESC -- 에러 발생
 
SELECT 
       DISTINCT ref_category_code AS 'rcc'
  FROM tbl_category
 ORDER BY -rcc DESC
 
SELECT
		 DISTINCT category_code, orderable_status
  FROM tbl_menu;
	 

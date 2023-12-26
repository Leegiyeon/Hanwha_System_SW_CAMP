-- 유재식 씨의 부서와 같은 부서에서 일하는 직원
SELECT *
  FROM employee;
  
  
-- 서브  
SELECT 
		 dept_code
  FROM employee
 WHERE emp_name = '유재식';
 
-- 메인
SELECT
		 *
  FROM employee
 WHERE dept_code = 'D6';
 
-- 서브쿼리를 포함한 메인쿼리
SELECT 
		 *
  FROM employee
 WHERE dept_code = (SELECT dept_code
 						    FROM employee
 						   WHERE emp_name = '유재식');
 						   
-- 이와 같은 방법으로 유재식씨 사원 번호를 추출해서 해당사원을 제거해 보자.
SELECT
		 *
  FROM employee
 WHERE dept_code = (SELECT dept_code
 						    FROM employee
 						   WHERE emp_name = '유재식')
 	AND emp_id != (SELECT emp_id
 						  FROM employee
 						 WHERE emp_name = '유재식');
 						 
 						 
-- 상관 서브 쿼리
-- 메뉴 조회 시, 메뉴의 카테고리에 있는 메뉴들의 평균 가격보다 높은 메뉴만 조회
-- (상관 서브쿼리, 단일행 서브쿼리)
SELECT
		 a.menu_code
	  , a.menu_name
	  , a.menu_price
	  , a.category_code
	  , a.orderable_status
  FROM tbl_menu a
 WHERE a.menu_price > (SELECT AVG(b.menu_price)
 								 FROM tbl_menu b
 								WHERE b.category_code = a.category_code);
 								
 
-- 메뉴 카테고리 평균과 같은 가격의 메뉴를 조회(상관 서브쿼리 안쓰고 다중행 서브쿼리) 						
SELECT
		 *
  FROM tbl_menu a
 WHERE a.menu_price IN (SELECT AVG(b.menu_price)
 								 FROM tbl_menu b
 								GROUP BY b.category_code);
 ORDER BY 1;
 
-- EXIST 
SELECT
		 a.category_code
	  , a.category_name
  FROM tbl_category a
 WHERE EXISTS (SELECT 1
  					  FROM tbl_menu b
 					 WHERE b.category_code = a.category_code);
 								
-- 5번 카테고리를 메인쿼리에서 where 조건 판별중 동작하는 서브쿼리 								
SELECT 1
  FROM tbl_menu b
 WHERE b.category_code = 5;
 

-- JOIN을 활용한 메뉴가 있는 카테고리 조회도 해보자
SELECT
		 a.category_code
	  , a.category_name
  FROM tbl_category a
  JOIN tbl_menu b ON (a.category_code = b.category_code)
 GROUP BY a.category_code, a.category_name;
 
 
 -- 가장 높은 급여를 받는 사원(MAX)
SELECT
		 emp_id
	  , emp_name
	  , MAX(salary)
  FROM employee;

-- 평균 급여가 가장 높은 부서(AVG,MAX) MAX(AVG)

-- i) 이중 서브쿼리
SELECT AVG(salary)
  FROM employee
 GROUP BY dept_code;

SELECT MAX(a.sal_avg)
  FROM (SELECT AVG(salary) as sal_avg
  			 FROM employee
  			GROUP BY dept_code) a;
  			
SELECT
		 dept_title
	  , dept_code
  FROM employee
  JOIN department a ON (a.DEPT_ID = employee.dept_code)
 GROUP BY dept_code
HAVING AVG(salary) = (SELECT MAX(a.sal_avg)
  								FROM (SELECT AVG(salary) as sal_avg
  			 							  FROM employee
  							  		 	 GROUP BY dept_code) a);

-- ii) >= ALL 활용
-- 서브쿼리 중에 다중행 서브쿼리인 경우에는 비교 연산자가 일반 비교 연산자와 달라진다.
-- > ALL, < ALL, > ANY, < ANY, IN
-- 1. > ALL: 모든 서브쿼리결과보다 크다.(서브 쿼리의 최댓값보다 크다)
-- 2. < ALL: 모든 서브쿼리결과보다 작다.(서브쿼리의 최솟값보다 작다)
-- 3. > ANY: 서브쿼리결과보다 최소 하나보다는 크다.(서브쿼리의 최솟값보다 크다)    
-- 4. < ANY: 서브쿼리결과보다 최대 하나보다는 작다.(서브쿼리의 최댓값보다 작다)
-- 5. IN: 서브쿼리 결과중에 하나라도 일치한다.

SELECT
		 dept_title
	  , dept_code
  FROM employee
  JOIN department a ON (a.DEPT_ID = employee.dept_code)
 GROUP BY dept_code
HAVING AVG(salary) >= ALL(SELECT AVG(salary)
  						   		 FROM employee 
  						  			GROUP BY dept_code); 
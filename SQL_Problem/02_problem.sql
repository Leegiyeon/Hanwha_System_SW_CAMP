-- 평균 대여 기간/7일 이상인 자동차들의
-- 자동차 ID, 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력
SELECT
       CAR_ID
     , ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) as AVERAGE_DURATION
  FROM car_rental_company_rental_history
 GROUP BY car_id
HAVING AVERAGE_DURATION >= 7
 ORDER BY AVERAGE_DURATION DESC, car_id DESC;

-- 2021년에 가입한 전체 회원들 중
-- 상품을 구매한 회원수와 상품을 구매한 회원의 비율
-- (=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력
SELECT YEAR(a.SALES_DATE)  AS YEAR
     , MONTH(a.SALES_DATE) AS MONTH
     , COUNT(DISTINCT a.USER_ID) AS PUCHASED_USERS
     , ROUND(COUNT(DISTINCT a.USER_ID)/(SELECT COUNT(1)
                                            FROM USER_INFO
                                           WHERE JOINED
                                            LIKE '2021%'), 1) AS PUCHASED_RATIO
  FROM ONLINE_SALE a
     , USER_INFO   b
 WHERE 1 = 1
   AND a.USER_ID = b.USER_ID
   AND b.JOINED  LIKE '2021%'
 GROUP BY YEAR, MONTH
 ORDER BY 1, 2;
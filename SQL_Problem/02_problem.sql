-- 평균 대여 기간/7일 이상인 자동차들의
-- 자동차 ID, 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력
SELECT
       CAR_ID
     , ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) as AVERAGE_DURATION
  FROM car_rental_company_rental_history
 GROUP BY car_id
HAVING AVERAGE_DURATION >= 7
 ORDER BY AVERAGE_DURATION DESC, car_id DESC;
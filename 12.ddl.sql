CREATE TABLE if NOT EXISTS tb1(
	pk INT PRIMARY KEY, -- UNIQUE, NOT NULL
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

DESC tb1;

INSERT
  INTO tb1
VALUES
(
	1, 2, 'Y'
);

SELECT * FROM tb1;

-- ---------------------------------------------------------
-- auto_increment
DROP TABLE tb2;

CREATE TABLE if NOT EXISTS tb2(
	pk INT PRIMARY KEY AUTO_INCREMENT, -- UNIQUE, NOT NULL
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

DESC tb2;

INSERT
  INTO tb2
VALUES
(
	NULL, 2, 'Y'
);

SELECT * FROM tb2;

ALTER TABLE tb2
ADD col2 INT NOT NULL;

-- 컬럼 삭제
ALTER TABLE tb2 DROP COLUMN col2;

-- 컬럼 정의 변경
ALTER TABLE tb2 
CHANGE COLUMN fk change_fk INT NOT NULL;

-- 제약조건 제거(auto_increment 설정 시, 오류 발생하므로 이하 실행)
ALTER TABLE tb2 DROP PRIMARY KEY; 

-- auto_increment 제거
ALTER TABLE tb2 MODIFY pk INT;

DESC tb2;

-- -----------------------------------------
-- TRUNCATE 

CREATE TABLE IF NOT EXISTS tb6
(
	pk INT AUTO_INCREMENT PRIMARY KEY,
	fk INT,
	col1 VARCHAR(255)
	CHECK(col1 IN ('Y','N'))
)ENGINE=INNODB;
	
	
INSERT
  INTO tb6
VALUES
(NULL, 10, 'Y'),
(NULL, 20, 'Y'),
(NULL, 30, 'Y'),
(NULL, 40, 'Y');

SELECT * FROM tb6;

-- 초기화
TRUNCATE tb6;
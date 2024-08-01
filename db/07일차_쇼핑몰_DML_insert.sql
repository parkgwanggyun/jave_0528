use shoppingmall;
# 제품 분류를 등록하는 쿼리 
INSERT INTO CATEGORY(CA_NAME) VALUES('옷'),('모자'),('신발'),('악세서리'),('기타');

# 사용자 회원가입하는 쿼리
# id : abc123, pw : abc123, email : abc123@naver.com, 번호 : 011-1234-5678
# id : qwe123, pw : qwe123, email : qwe123@naver.com, 번호 : 011-1111-2222
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_PHONE, ME_AUTHORITY, ME_FAIL) VALUES
('abc123', 'abc123', 'abc123@naver.com', '011-1234-5678', 'USER', 0), 
('qwe123', 'qwe123', 'qwe123@naver.com', '011-1111-2222', 'USER', 0);

# 제품 등록하는 쿼리 
# 분류 : 옷, 코드 : CLO001, 상품명 : 시원한 티셔츠, 가격 : 20000, 내용 : 티셔츠를 입으면 시원해요.
# 분류 : 옷, 코드 : CLO002, 상품명 : 시원한 반바지, 가격 : 15000, 내용 : 여름 전용 반바지입니다.
# 분류 : 옷, 코드 : CLO003, 상품명 : 시원한 양말, 가격 : 20000, 내용 : 시원한 의류 시리즈 마지막 용품입니다.
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'CLO001', '시원한 티셔츠', '티셔츠를 입으면 시원해요.', '20000', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '옷';
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'CLO002', '시원한 반바지', '여름 전용 반바지입니다.', '15000', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '옷';
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'CLO003', '시원한 양말', '시원한 의류 시리즈 마지막 용품입니다.', '20000', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '옷';
# 분류 : 모자, 코드 : CAP001, 상품명 : 여름 모자, 가격 : 30000, 내용 : 그늘을 만들어줘요. 
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'CAP001', '여름 모자', '그늘을 만들어줘요.', '30000', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '모자';
# 분류 : 신발, 코드 : SHO001, 상품명 : 싼 크룩스 , 가격 : 19999, 내용 : 인기 신발.
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'SHO001', '싼 크룩스', ' 인기 신발.', '19999', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '신발';
# 분류 : 악세서리, 코드 : ACC001, 상품명 : 금 목걸이, 가격 : 100000, 내용 : 부의 상징.
INSERT INTO PRODUCT(PR_CODE, PR_NAME, PR_CONTENT, PR_PRICE, PR_CA_NUM) 
SELECT 'ACC001', '금 목걸이', '부의 상징.', '100000', CA_NUM 
FROM CATEGORY 
WHERE CA_NAME = '악세서리';

#abc123 회원이 CLO001번 제품을 장버구니에 3개를 담았을 때 쿼리
insert into basket(BA_PR_CODE, BA_ME_ID, BA_AMOUNT) value('CLO001','abc123',3);
#abc123 회원이 1번 제품을 장바구니에 2개 담았을 때 쿼리
update basket set ba_amount =2 where ba_pr_code = 'CLO001' and BA_ME_ID='abc123';
#abc123 회원이 ACC001 제품을 장바구니에 1개 담았을 쿼리
insert into basket(BA_PR_CODE, BA_ME_ID, BA_AMOUNT) value('ACC001','abc123',1);
#abc123회원이 장바구니에 있는 모든 제품을 구매했을 때 필요한 모든 쿼리
insert into buy(bu_pr_code, bu_me_id, bu_amount, bu_state, bu_date)
value('CLO001','abc123',3,'구매',now()),
('ACC001','abc123',1,'구매',now());

delete from basket where ba_pr_code = 'CLO001' and BA_ME_ID='abc123';
delete from basket where ba_pr_code = 'ACC001' and BA_ME_ID='abc123';

#abc123회원이 id : abc123, pw : abc1234로 로그인 시도했을 때 실행해야하는 쿼리
update member set me_fail = me_fail + 1 where me_id = 'abc123';

#abc123회원이 로그인 시도가 성공했을 떄 실행해야하는 쿼리
update member set me_fail = 0 where me_id = 'abc123';

#abc123회원이 비번 찾기를 시도해서 인증코드가 123asd가 발급됐을 때 실행해야하는 쿼리
insert into code(co_me_id,co_code, co_limit) value('abc123','123asd',DATE_ADD(now(), INTERVAL 5 minute)); 
#abc123회원이 인증코드를 입력해서 비번을 abc1234로 수정했을 때 실행해야하는 쿼리
update member set me_pw = 'abc1234' where me_id = 'abc123';
#인증코드를 통해 비번을 변경했으면 인증코드를 삭제
delete from code where co_me_id = 'abc123';
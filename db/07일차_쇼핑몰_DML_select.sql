
# 분류별 등록된 제품수를 조회하는 쿼리 
SELECT 
    CA_NAME 분류명, COUNT(PR_CODE) 제품수
FROM
    PRODUCT
RIGHT JOIN
	CATEGORY ON CA_NUM = PR_CA_NUM
GROUP BY CA_NUM;
# 옷으로 등록된 제품들을 조회하는 쿼리
select
	pr_name 제품명,pr_content 설명, pr_price 가격,ca_name 분류
from
	product
join
	category on pr_ca_num = ca_num
WHERE 
    ca_name = '옷';
# '시원한' 이 들어간 제품을 검색 => 제목에 '시원한'이 포함된 제품을 조회하는 쿼리
select
	*
from 
	product
where
	pr_name like concat('%','시원한','%');
# 누적 판매량이 가장 많은 제품들을 조회하는 쿼리
select
	dense_rank() over(order by sum(bu_amount)DESC)판매순위, product.*,sum(bu_amount)판매량
from
	product
left join
	(select * from buy where bu_state in('구매','구매확정')) B on bu_pr_code = pr_code
group by pr_code
;
# 옷 제품들 중에서 가격이 높은 순으로 제품을 조회하는 쿼리
select
	dense_rank() over(order by pr_price desc)높은순,product.*
from
	product
join
	category on pr_ca_num = ca_num
where
	ca_name = '옷';
# abc123회원이 구매 목록을 조회하는 쿼리
select distinct bu_pr_code from buy where bu_me_id = 'abc123' and bu_state in('구매');
#abc123회원이 누적 구매 금액을 조회하는 쿼리
select 
	bu_me_id 구매자,sum(pr_price)총구매액 
from 
	product 
join 
	buy on bu_pr_code = pr_code 
where 
	bu_me_id = 'abc123' and bu_state in('구매');
#회원별 누적 금액을 조회하는 쿼리
select
	me_id,ifnull(format(sum(pr_price * bu_Amount),0),0)  누적구매금액
from
	member
		left join
		(select * from buy where bu_state in('구매','구매확정')) b on me_id = bu_me_id
		left join
		product on pr_code = bu_pr_code
group by me_id;
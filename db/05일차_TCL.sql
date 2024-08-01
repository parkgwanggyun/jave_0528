use product;
# 트렌젝션을 시작 : commit 할 때까지 최종 적용이 안됨.
start transaction; 

update product set pr_price = pr_price + 20000 where pr_code = 'ab1';
select *from product;
savepoint a1;
update product set pr_price = pr_price + 22000 where pr_code = 'ab1';
savepoint a2;
rollback to a1;
select * from product;
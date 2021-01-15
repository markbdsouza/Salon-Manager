--create 3 employees
insert into employees (id,employee_id,created_by, created_date, last_modified_by, last_modified_date, first_name, last_name,email, joining_date,
is_owner, phone_number, summary,years_in_industry)
   values (900,'E100', 'admin',sysdate,'admin',sysdate,'Mark','last','Mark@owner.com',sysdate, false,'123123','2summary', 5.2);
insert into employees (id,employee_id,created_by, created_date, last_modified_by, last_modified_date, first_name, last_name,email, joining_date,
is_owner, phone_number, summary,years_in_industry)
   values (901,'E101', 'admin',sysdate,'admin',sysdate,'Jonn','Luiz','JonnLuiz@gmail.com',sysdate, false,'8214-213-512','Hair Styling Expert', 10);
insert into employees (id,employee_id,created_by, created_date, last_modified_by, last_modified_date, first_name, last_name,email, joining_date,
is_owner, phone_number, summary,years_in_industry)
   values (902,'E102', 'admin',sysdate,'admin',sysdate,'Marie','Luiz','Marie@owner.com',sysdate, false,'2151002132','Vast Experience in Hair Treatment', 9.2);

-- create 2 customers
insert into customers (created_by, created_date, last_modified_by, last_modified_date, customer_id, email, first_name, last_name, phone_number, id)
   values ('admin',sysdate,'admin',sysdate,'BakHxqf9Me4mH2FIG66RhzYiUPKJf8','mark@last.com','Mark','last','123123','2');
insert into customers (created_by, created_date, last_modified_by, last_modified_date, customer_id, email, first_name, last_name, phone_number, id)
   values ('admin',sysdate,'admin',sysdate,'Pa2Hxqf9Me4mH2FIG66RhzYiUPKJf8','mouse@last.com','nouse','lblous','51232','3');

-- create services
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
   values('100', 'HR412', 300, 'Keratin Treatment' , 700, 'Hair Treatment','Keratin Tretment for Frizzy hair', 10, 'Keratin treatment for hair description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('101', 'HR413', 250, 'Hair Straightening' , 700, 'Hair Treatment','Straightening for hair', 10, 'Straigtening treatment for hair description description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('102', 'HS01', 30, 'Hair Cut-Men' , 300, 'Hair Styling','Hair cut for men', 10, 'Hair cut for men description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('103', 'HS10', 45, 'Hair Cut-Men Medium' , 400, 'Hair Styling','Hair cut for men', 10, 'Hair cut for men description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('104', 'HS02', 60, 'Hair Cut-Women(Short)' , 400, 'Hair Styling','Hair cut for women short hair', 12, 'Hair cut for women short hair description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('105', 'HS03', 75, 'Hair Cut-Women(Medium)' , 500, 'Hair Styling','Hair cut for women medium hair', 15, 'Hair cut for women medium hair description','admin',sysdate,'admin',sysdate);
insert into services (id, service_type_id, estimated_minutes,name, service_cost, service_type, summary, tax_cost, description, created_by, created_date, last_modified_by, last_modified_date)
      values('106', 'HS06', 90, 'Hair Cut-Women(Long)' ,600, 'Hair Styling','Hair cut for women long hair', 18, 'Hair cut for women long hair description','admin',sysdate,'admin',sysdate);

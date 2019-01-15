SELECT
department.id AS department_id,
department.`name`,
project.id AS project_id,
select_all_financial_information.log_id,
select_all_financial_information.log_num,
select_all_financial_information.log_type,
select_all_financial_information.tax_rate
FROM
department
INNER JOIN project ON project.department_id = department.id ,
select_all_financial_information
WHERE
project.id = select_all_financial_information.project_Id
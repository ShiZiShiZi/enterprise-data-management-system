SELECT
department.id,
department.`name`,
project_member.project_people_id
FROM
project_member
INNER JOIN project ON project_member.project_id = project.id
INNER JOIN department ON project.department_id = department.id
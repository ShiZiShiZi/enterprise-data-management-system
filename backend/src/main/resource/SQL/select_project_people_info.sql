select `department`.`id` AS `id`,`department`.`name` AS `departmentname`,`projectpeople`.`name` AS `name`,`projectpeople`.`email` AS `email`,`projectpeople`.`phonenum` AS `phonenum`,`projectpeople`.`password` AS `password`,`projectpeople`.`departmentid` AS `departmentid`,`projectpeople`.`acrossdepartment` AS `acrossdepartment`,`projectpeople`.`permissions` AS `permissions` from (`department` join `projectpeople` on((`projectpeople`.`departmentid` = `department`.`id`))) where (`department`.`id` = `projectpeople`.`departmentid`)
drop table if exists sale;

drop table if exists employer;

drop table if exists provide;

drop table if exists store;

drop table if exists goods;

drop table if exists storage;

drop table if exists suppliers;
/*==============================================================*/
/* Table: employer                                              */
/*==============================================================*/
create table employer
(
   workerNum            varchar(10) not null,
   name                 varchar(20),
   age                  smallint,
   sex                  varchar(6),
   phoneNum             varchar(11),
   workTime             smallint,
   office               varchar(20),
   salary               bigint,
   primary key (workerNum)
   
);

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goodsNum             varchar(10) not null,
   goodsName            varchar(20),
   goodsType            varchar(10),
   goodsPrice           int,
   goodsCost            int,
   primary key (goodsNum)
);
/*==============================================================*/
/* Table: suppliers                                             */
/*==============================================================*/
create table suppliers
(
   supplierNum          varchar(10) not null,
   supplierName         varchar(20),
   supplierAddress     varchar(100),
   supplierPhone        varchar(11),
   primary key (supplierNum)
);
/*==============================================================*/
/* Table: provide                                               */
/*==============================================================*/
create table provide
(
	
    id					int not null,
   sup_supplierNum      varchar(10) not null,
   goo_goodsNum         varchar(10) not null,
   supplierDate         date not null,
   supplierSum          int not null,
   primary key (id),
   foreign key(sup_supplierNum) references suppliers(supplierNum)
   on delete cascade
   on update cascade,
   foreign key(goo_goodsNum) references goods(goodsNum)
   on delete cascade
   on update cascade
);

/*==============================================================*/
/* Table: sale                                                  */
/*==============================================================*/
create table sale
(
    id					int not null,
   emp_workerNum        varchar(10) not null,
   goo_goodsNum         varchar(10) not null,
   saleTime             date not null,
   saleNum              int not null ,
   primary key (id),
   foreign key(emp_workerNum) references employer(workerNum)
   on delete cascade
   on update cascade,
   foreign key(goo_goodsNum) references goods(goodsNum)
   on delete cascade
   on update cascade
);

/*==============================================================*/
/* Table: storage                                               */
/*==============================================================*/
create table storage
(
   storageNum           varchar(10) not null,
   storageName          varchar(20),
   storageAddress       varchar(40),
   primary key (storageNum)
);

/*==============================================================*/
/* Table: store                                                 */
/*==============================================================*/
create table store
(
    id					int not null,
   sto_storageNum       varchar(10) not null,
   goo_goodsNum         varchar(10) not null,
   storageSum           bigint not null,
   primary key (id),
   foreign key(sto_storageNum) references storage(storageNum)
   on delete cascade
   on update cascade,
   foreign key(goo_goodsNum) references goods(goodsNum)
   on delete cascade
   on update cascade
);

insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202201', '钟展鹏', '15153708058', '3', 23, '女', 145, 12607);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202202', '萧思淼', '15985112630', '2', 25, '女', 329, 7200);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202203', '龚黎昕', '15024635352', '2', 43, '男', 8, 4733);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202204', '黄弘文', '17209583627', '3', 34, '女', 7980, 2262);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202205', '陆瑾瑜', '15648605033', '4', 35, '男', 29957, 6000);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202206', '杜明辉', '17817071748', '1', 44, '男', 13215, 77688);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202207', '刘浩宇', '15093221531', '3', 55, '男', 6346, 9730);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202208', '江振家', '15946440630', '2', 62, '男', 5070, 2531);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202209', '何航', '15663817798', '4', 50, '女', 813, 25278);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202210', '方烨磊', '17006316935', '4', 18, '男', 3042, 6000);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202211', '潘博文', '15651067405', '1', 34, '男', 791, 8000);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202212', '孔振家', '14761874193', '3', 56, '女', 2983, 7252);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202213', '袁晟睿', '13166747863', '1', 23, '男', 5, 8300);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202214', '邱鹏煊', '15134849054', '2', 53, '女', 7108, 4010);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202215', '孟博超', '17879836019', '1', 26, '女', 22, 71260);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202216', '萧瑾瑜', '17778958761', '1', 46, '女', 532, 5834);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202217', '钱彬', '15751091763', '1', 33, '女', 600, 8220);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202218', '白烨霖', '15655114556', '2', 50, '男', 640, 8791);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202219', '陆博超', '15942010506', '5', 23, '男', 8044, 9782);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202220', '苏子轩', '14560582498', '1', 20, '男', 7715, 8096);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202221', '赵鑫磊', '17078167924', '2', 58, '男', 738, 6339);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202222', '程伟诚', '17525969901', '3', 48, '男', 728, 3722);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202223', '韩楷瑞', '13571359080', '4', 46, '女', 400, 2006);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202224', '韦聪健', '15151004146', '3', 20, '男', 426, 58342);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202225', '钟浩轩', '17048850375', '2', 27, '男', 80, 1220);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202226', '侯越彬', '15234003742', '5', 24, '男', 1007, 7500);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202227', '贾雨泽', '17628049121', '3', 22, '女', 838, 49678);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202228', '许雨泽', '17520946106', '1', 62, '男', 3, 9642);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202229', '曹浩', '14529334541', '2', 18, '男', 411, 3300);
insert into `Employer` (`workernum`, `name`, `phoneNum`, `office`, `age`, `sex`, `workTime`, `salary`) values ('202230', '郝乐驹', '17847125199', '4', 62, '男', 92, 62980);

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '可乐', '饮料', 4, 3);
INSERT INTO `goods` VALUES ('2', '可乐2', '饮料', 4, 3);
INSERT INTO `goods` VALUES ('2022001', 'blz', '6', 86, 3);
INSERT INTO `goods` VALUES ('2022002', 'toi', '6', 34, 45);


insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('75','蒋桂英','贵州省 黔东南苗族侗族自治州 镇远县','18959569681');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('08','邓伟','河北省 廊坊市 香河县','18972500117');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('24','汤洋','江苏省 常州市 新北区','13207264716');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('46','薛军','内蒙古自治区 呼伦贝尔市 鄂温克族自治旗','13555312856');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('61','郭霞','海南省 三沙市 南沙群岛','13505132838');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('52','傅秀兰','辽宁省 铁岭市 调兵山市','13285118281');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('35','谭涛','重庆 重庆市 南岸区','13238232205');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('71','康涛','西藏自治区 拉萨市 林周县','13567593743');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('47','邱芳','台湾 南投县 信义乡','13547905601');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('01','侯杰','宁夏回族自治区 中卫市 中宁县','18951226210');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('85','郑秀英','辽宁省 沈阳市 大东区','13251937436');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('82','余杰','青海省 海东市 乐都区','13591652841');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('34','秦敏','新疆维吾尔自治区 博尔塔拉蒙古自治州 博乐市','13546558784');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('05','李超','贵州省 黔南布依族苗族自治州 龙里县','13290782774');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('76','尹涛','河北省 沧州市 海兴县','13236178222');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('73','丁秀英','湖南省 益阳市 资阳区','18941655925');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('79','方芳','吉林省 辽源市 东丰县','13577655388');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('81','郭军','湖北省 荆州市 公安县','13273332758');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('15','任强','河南省 商丘市 永城市','18955613206');
insert into `suppliers` (`supplierNum`,`supplierName`,`supplierAddress`,`supplierPhone`) value ('26','薛平','上海 上海市 静安区','13593827458');


insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (01,'75','2022014','1972-02-02','7');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (02,'08','2022011','1983-11-10','35');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (03,'24','2022013','1980-01-15','8');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (04,'46','2022025','1982-08-22','14');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (05,'61','2022042','1989-05-10','13');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (06,'52','2022037','2010-07-17','85');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (07,'35','2022049','1978-06-20','75');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (08,'15','2022039','1993-12-24','36');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (09,'52','2022044','2019-05-22','49');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (10,'15','2022031','2011-08-10','16');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (11,'15','2022019','1974-04-06','40');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (12,'35','2022031','2011-12-12','108');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (13,'52','2022017','1992-02-10','11');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (14,'35','2022011','1974-06-09','16');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (15,'35','2022035','1985-04-28','66');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (16,'35','2022013','1982-06-01','62');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (17,'35','2022024','2006-11-11','9');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (18,'35','2022019','2011-12-28','45');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (19,'46','2022023','1990-12-27','34');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (20,'47','2022028','2012-10-11','54');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (21,'71','2022012','1987-11-09','50');
insert into `provide` (`id`,`sup_supplierNum`,`goo_goodsNum`,`supplierDate`,`supplierSum`) value (22,'15','2022016','1978-02-20','76');


insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (1,'202201','2022018','2002-10-08','84');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (2,'202202','2022013','1999-09-02','75');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (3,'202203','2022028','2019-05-20','8');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (4,'202204','2022020','1998-04-13','16');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (5,'202205','2022021','2004-06-23','45');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (6,'202206','2022025','1991-05-23','111');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (7,'202207','2022026','2007-06-07','73');
insert into `sale` (`id`,`emp_workerNum`,`goo_goodsNum`,`saleTime`,`saleNum`) value (8,'202209','2022040','2000-09-04','76');

insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202204','gjjt','上海 上海市 闵行区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202214','qyi','浙江省 宁波市 江北区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202212','qvejc','安徽省 黄山市 祁门县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202203','yvje','河南省 安阳市 殷都区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202229','vvqb','辽宁省 丹东市 宽甸满族自治县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202201','kfyfx','青海省 海东市 乐都区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202216','xpdd','西藏自治区 山南地区 桑日县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202213','aeibt','重庆 重庆市 渝北区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202220','crld','山西省 晋中市 左权县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202223','gkb','海南省 海口市 琼山区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202217','tvqf','海外 海外 -');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202222','qxxb','山东省 青岛市 其它区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202226','dups','河南省 鹤壁市 山城区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202210','npgdu','辽宁省 抚顺市 望花区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202205','nky','上海 上海市 浦东新区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202206','ozc','香港特别行政区 香港岛 东区');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202218','tssby','山西省 长治市 沁源县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202202','uqum','山东省 泰安市 宁阳县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202227','jgid','青海省 玉树藏族自治州 囊谦县');
insert into `storage` (`storageNum`,`storageName`,`storageAddress`) value ('202228','lms','青海省 黄南藏族自治州 河南蒙古族自治县');

insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (1,'202213','2022043','82');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (2,'202220','2022047','24');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (3,'202214','2022017','79');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (4,'202223','2022044','8');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (5,'202222','2022015','25');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (6,'202216','2022034','111');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (7,'202228','2022014','24');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (8,'202212','2022049','38');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (9,'202220','2022020','112');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (10,'202201','2022047','14');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (11,'202212','2022045','92');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (12,'202206','2022046','62');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (13,'202217','2022027','115');
insert into `store` (`id`,`sto_storageNum`,`goo_goodsNum`,`storageSum`) value (14,'202201','2022039','40');

SET SQL_SAFE_UPDATES = 0;



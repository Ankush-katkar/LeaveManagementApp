alter table leaveapply add column days int(11) after status;
alter table leaveapply modify column days bigint(20);
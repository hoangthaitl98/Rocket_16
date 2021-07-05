-- Testing system assignment 4 --
-- 1 -- 
USE `Testing_System`;

SELECT A.FullName, D.*
FROM `account` as A
LEFT JOIN `department`as D ON A.DepartmentId = D.DepartmentId;

-- 2 --
SELECT *
FROM `account` as A
WHERE A.CreateDate < '2010-12-20';

-- 3 --
SELECT A.FullName
FROM `account` as A
LEFT JOIN `position` as P ON A.PositionID = P.PositionID
WHERE P.PositionID = 4;

-- 4 -- 
SELECT D.*, COUNT(A.AccountId) AS 'so nhan vien'
FROM `account` A
INNER JOIN `department` AS D ON A.DepartmentID = D.DepartmentId 
GROUP BY A.DepartmentId
HAVING `so nhan vien` > 3;

-- 5 --
SELECT E.ExamID, count(EQ.QuestionID) as'so cau hoi'
FROM examquestion as EQ
JOIN exam as E ON E.ExamID = EQ.ExamID
Group by EQ.QuestionID
having count(EQ.QuestionID) = (SELECT MAX(`TEMP`.countQuestion)
								FROM (SELECT count(QuestionID)  countQuestion
										FROM examquestion
										group by QuestionID) as `TEMP`);

-- 6 --
SELECT CG.*, count(Q.CategoryID) as `so question`
FROM question as Q
join CategoryQuestion as CG on Q.CategoryID = CG.CategoryID
group by Q.CategoryID
order by CG.CategoryID;

-- 7 --
SELECT count(Q.QuestionID) `so exam`, EQ.QuestionID
from examquestion as EQ
right join question as Q on Q.QuestionID = EQ.QuestionID
group by Q.QuestionID;

-- 8 -- 
SELECT Q.*, count(AN.QuestionID) as 'so cau tra loi'
FROM Answer as AN
JOIN Question as Q On Q.QuestionID = AN.QuestionID
group by AN.QuestionID
having count(AN.QuestionID) = (SELECT MAX(`TEMP`.countQues) 
								FROM (SELECT count(A.QuestionID) as countQues
										FROM answer as A
										group by A.QuestionID) as `TEMP`);
                                        
-- 9 --
SELECT G.*, count(GA.AccountId) as 'so account'
FROM groupaccount as GA
JOIN `group` as G on G.GroupID = GA.GroupID
group by GA.AccountID;

-- 10 --
SELECT P.*, count(AC.AccountId)
FROM `account` as AC
JOIN position as P on P.PositionID = AC.PositionID
group by AC.PositionID
having count(AC.AccountId) = (SELECT MIN(`TEMP`.soNhanVien) 
								FROM (SELECT count(A.AccountID) as soNhanVien
									FROM `account` as A
									group by A.PositionID) as `TEMP`);

-- 11 -- 
SELECT D.DepartmentId, P.PositionName, COUNT(P.PositionName) as 'so luong'
FROM department as D
JOIN `account` as A ON A.DepartmentId = D.DepartmentId
JOIN position as P ON P.PositionID = A.PositionID
group by D.DepartmentId, P.PositionID;

-- 12 --
SELECT Q.QuestionID, Q.Content, TQ.TypeName, A.Content as 'dap an', CQ.CategoryName, AC.FullName as 'nguoi tao cau hoi'
FROM question as Q
INNER JOIN typequestion as TQ ON Q.TypeID = TQ.TypeID
INNER JOIN answer as A ON A.QuestionID = Q.QuestionID
INNER JOIN categoryquestion as CQ ON CQ.CategoryID = Q.CategoryID
INNER JOIN `account` as AC ON AC.AccountId = Q.CreatorID
order by QuestionID asc;

-- 13 --
SELECT typequestion.TypeName, count(question.TypeID)
FROM question
INNER JOIN typequestion ON question.TypeID = typequestion.TypeID
group by question.TypeID;

-- 14, 15 --
SELECT G.GroupID
FROM `group` as G
WHERE G.GroupID NOT IN (select GroupID
						from groupaccount);

-- 16 --
SELECT Q.QuestionID
FROM answer as A
RIGHT JOIN question as Q ON A.QuestionID = Q.QuestionID
WHERE A.AnswerID IS null;

-- 17a --
SELECT GC.AccountID
FROM groupaccount as GC
WHERE GC.GroupID = 1;

-- 17b --
SELECT GC.AccountID
FROM groupaccount as GC
WHERE GC.GroupID = 2;

-- 17c --
SELECT GC.AccountID
FROM groupaccount as GC
WHERE GC.GroupID = 1
UNION
SELECT GC.AccountID
FROM groupaccount as GC
WHERE GC.GroupID = 2;

-- 18a --
SELECT G.GroupName, G.GroupID, count(GC.GroupID) as soLuong
FROM groupaccount as GC
JOIN `group` as G ON G.GroupID = GC.GroupID
group by GC.GroupID
having soLuong > 5;

-- 18b --
SELECT G.GroupName, G.GroupID, count(GC.GroupID) as soLuong
FROM groupaccount as GC
JOIN `group` as G ON G.GroupID = GC.GroupID
group by GC.GroupID
having soLuong < 7;

-- 18c --
SELECT G.GroupName, G.GroupID, count(GC.GroupID) as soLuong
FROM groupaccount as GC
JOIN `group` as G ON G.GroupID = GC.GroupID
group by GC.GroupID
having soLuong > 5
UNION
SELECT G.GroupName, G.GroupID, count(GC.GroupID) as soLuong
FROM groupaccount as GC
JOIN `group` as G ON G.GroupID = GC.GroupID
group by GC.GroupID
having soLuong < 7;
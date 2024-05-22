CREATE TABLE KHACHTHUE 
(
  MAKT CHAR(6 BYTE) 
, HOTEN VARCHAR2(60 BYTE) 
, GIOITINH VARCHAR2(10 BYTE) 
, NGAYSINH DATE 
, SDT VARCHAR2(20 BYTE) 
, CCCD VARCHAR2(20 BYTE) 
, EMAIL VARCHAR2(60 BYTE) 
, NGAYBATDAU DATE 
, NGAYKETTHUC DATE 
) 
CREATE TABLE KHACHNGANHAN 
(
  MAKT CHAR(6 BYTE) 
, HOTEN VARCHAR2(60 BYTE) 
, GIOITINH VARCHAR2(10 BYTE) 
, NGAYSINH DATE 
, SDT VARCHAR2(20 BYTE) 
, CCCD VARCHAR2(20 BYTE) 
, EMAIL VARCHAR2(60 BYTE) 
, MADD CHAR(6 BYTE) 
, TRANGTHAI VARCHAR2(20 BYTE) 
, NGAYBATDAU DATE 
, NGAYKETTHUC DATE 
) 
CREATE TABLE PHONG 
(
  MAP CHAR(4 BYTE) 
, TENPG VARCHAR2(10 BYTE) 
, LOAI VARCHAR2(20 BYTE) 
, SONGUOI NUMBER(*, 0) 
, DIENTICH NUMBER(*, 0) 
, TRANGTHAI VARCHAR2(20 BYTE)  
, GIA NUMBER(*, 0) 
) 
CREATE TABLE HOPDONG 
(
  MHD CHAR(6 BYTE) 
, NGAYBATDAU DATE 
, NGAYKETTHUC DATE 
, MADD CHAR(6 BYTE) 
, MAP CHAR(4 BYTE) 
, GIATHUE NUMBER(*, 0) 
, TIENCOC NUMBER 
, TINHTRANG VARCHAR2(20 BYTE) 
) 
CREATE TABLE CTHOPDONG 
(
  MHD CHAR(6 BYTE) 
, MAKT CHAR(6 BYTE) 
) 
CREATE TABLE HOADON 
(
  MAHD CHAR(6 BYTE) 
, MAP CHAR(4 BYTE) 
, THANG NUMBER(*, 0) 
, NAM NUMBER(*, 0) 
, TONGTIEN NUMBER(*, 0) 
, TRANGTHAI VARCHAR2(30 BYTE) 
, CONNO NUMBER(*, 0) 
) 
CREATE TABLE CTHD 
(
  MAHD CHAR(6 BYTE) 
, LOAIHD VARCHAR2(20 BYTE) 
, SL NUMBER(*, 0) 
, DONGIA NUMBER(*, 0) 
, THANHTIEN NUMBER(*, 0) 
) 
CREATE TABLE DICHVU 
(
  MADV CHAR(6 BYTE) 
, TENDICHVU VARCHAR2(40 BYTE) 
) 
CREATE TABLE PHIEUDICHVU 
(
  MPDV CHAR(6 BYTE) 
, MAP CHAR(4 BYTE) 
, SOLUONGDV NUMBER(*, 0) 
, NGAYDIEN DATE 
) 
CREATE TABLE CTPDV 
(
  MADV CHAR(6 BYTE) 
, MPDV CHAR(6 BYTE) 
, TINHTRANG VARCHAR2(20 BYTE) 
)
CREATE TABLE TAIKHOAN 
(
  MAKT CHAR(6 BYTE) 
, TENTAIKHOAN VARCHAR2(40 BYTE) 
, MATKHAU VARCHAR2(40 BYTE) 
, VAITRO VARCHAR2(20 BYTE) 
)  

-- Dữ liệu cho bảng KHACHTHUE 
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0001', 'Nguyễn Văn A', 'Nam', TO_DATE('01-01-2004', 'DD-MM-YYYY'), '+84123456781', '123456789', 'nguyenvana@example.com', TO_DATE('01-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024','DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0002', 'Trần Thị B', 'Nữ', TO_DATE('02-02-2003', 'DD-MM-YYYY'), '+84123456782', '234567890', 'tranthib@example.com', TO_DATE('02-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0003', 'Phạm Văn C', 'Nam', TO_DATE('03-03-2003', 'DD-MM-YYYY'), '+84123456783', '345678901', 'phamvanc@example.com', TO_DATE('03-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0004', 'Lê Thị D', 'Nữ', TO_DATE('04-04-2003', 'DD-MM-YYYY'), '+84123456784', '456789012', 'lethid@example.com', TO_DATE('04-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0005', 'Nguyễn Văn E', 'Nam', TO_DATE('05-05-2004', 'DD-MM-YYYY'), '+84123456785', '567890123', 'nguyenvane@example.com', TO_DATE('05-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0006', 'Trần Văn F', 'Nam', TO_DATE('06-06-2003', 'DD-MM-YYYY'), '+84123456786', '678901234', 'tranvanf@example.com', TO_DATE('01-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0007', 'Lê Thị G', 'Nữ', TO_DATE('07-07-1996', 'DD-MM-YYYY'), '+84123456787', '789012345', 'lethig@example.com', TO_DATE('02-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0008', 'Nguyễn Văn H', 'Nam', TO_DATE('08-08-1992', 'DD-MM-YYYY'), '+84123456788', '890123456', 'nguyenvanh@example.com', TO_DATE('03-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0009', 'Phạm Thị I', 'Nữ', TO_DATE('09-09-1991', 'DD-MM-YYYY'), '+84123456789', '901234567', 'phamthii@example.com', TO_DATE('04-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, NGAYBATDAU, NGAYKETTHUC) VALUES ('KT0010', 'Trần Văn K', 'Nam', TO_DATE('10-10-1994', 'DD-MM-YYYY'), '+84123456790', '012345678', 'tranvank@example.com', TO_DATE('05-01-2024', 'DD-MM-YYYY'), TO_DATE('31-12-2024', 'DD-MM-YYYY'));

-- Dữ liệu cho bảng KHACHNGANHAN
INSERT INTO KHACHNGANHAN (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, MADD, TRANGTHAI, NGAYBATDAU, NGAYKETTHUC) VALUES ('KNH001', 'Nguyễn Thị A', 'Nữ', TO_DATE('01-01-1995', 'DD-MM-YYYY'), '+84123456791', '123456789', 'nguyenthia@example.com', 'KT0001', 'Chờ duyệt', TO_DATE('01-01-2024', 'DD-MM-YYYY'), TO_DATE('31-01-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHNGANHAN (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, MADD, TRANGTHAI, NGAYBATDAU, NGAYKETTHUC) VALUES ('KNH002', 'Trần Văn B', 'Nam', TO_DATE('02-02-1994', 'DD-MM-YYYY'), '+84123456792', '234567890', 'tranvanb@example.com', 'KT0002', 'Đã duyệt', TO_DATE('02-01-2024', 'DD-MM-YYYY'), TO_DATE('31-01-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHNGANHAN (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, MADD, TRANGTHAI, NGAYBATDAU, NGAYKETTHUC) VALUES ('KNH003', 'Phạm Thị C', 'Nữ', TO_DATE('03-03-1993', 'DD-MM-YYYY'), '+84123456793', '345678901', 'phamthic@example.com', 'KT0003', 'Chờ duyệt', TO_DATE('03-01-2024', 'DD-MM-YYYY'), TO_DATE('31-01-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHNGANHAN (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, MADD, TRANGTHAI, NGAYBATDAU, NGAYKETTHUC) VALUES ('KNH004', 'Lê Thị D', 'Nữ', TO_DATE('04-04-1992', 'DD-MM-YYYY'), '+84123456794', '456789012', 'lethid@example.com', 'KT0004', 'Chờ duyệt', TO_DATE('04-01-2024', 'DD-MM-YYYY'), TO_DATE('31-01-2024', 'DD-MM-YYYY'));
INSERT INTO KHACHNGANHAN (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL, MADD, TRANGTHAI, NGAYBATDAU, NGAYKETTHUC) VALUES ('KNH005', 'Nguyễn Văn E', 'Nam', TO_DATE('05-05-1991', 'DD-MM-YYYY'), '+84123456795', '567890123', 'nguyenvane@example.com', 'KT0005', 'Đã duyệt', TO_DATE('05-01-2024', 'DD-MM-YYYY'), TO_DATE('31-01-2024', 'DD-MM-YYYY'));


-- Dữ liệu cho bảng PHONG
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P001', 'P101', 'Sinh viên', 2, 25, 'Đã cho thuê', 3000000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P002', 'P102', 'Sinh viên', 2, 20, 'Đã cho thuê', 3200000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P003', 'P103', 'Sinh viên', 1, 30, 'Đã cho thuê', 3300000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P004', 'P104', 'Sinh viên', 1, 22, 'Đã cho thuê', 3100000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P005', 'P105', 'Sinh viên', 0, 18, 'Còn trống', 3400000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P006', 'P106', 'Sinh viên', 0, 25, 'Còn trống', 3500000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P007', 'P107', 'Sinh viên', 0, 20, 'Còn trống', 3200000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P008', 'P108', 'Sinh viên', 0, 30, 'Còn trống', 3300000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P009', 'P109', 'Sinh viên', 0, 22, 'Còn trống', 3100000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P010', 'P110', 'Sinh viên', 0, 18, 'Còn trống', 3400000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P011', 'P201', 'Gia đình', 2, 25, 'Đã cho thuê', 3500000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P012', 'P202', 'Gia đình', 2, 20, 'Đã cho thuê', 3200000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P013', 'P203', 'Gia đình', 0, 30, 'Còn trống', 3300000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P014', 'P204', 'Gia đình', 0, 22, 'Còn trống', 3100000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P015', 'P205', 'Gia đình', 0, 18, 'Còn trống', 3400000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P016', 'P206', 'Gia đình', 0, 25, 'Còn trống', 3500000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P017', 'P207', 'Gia đình', 0, 20, 'Còn trống', 3200000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P018', 'P208', 'Gia đình', 0, 30, 'Còn trống', 3300000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P019', 'P209', 'Gia đình', 0, 22, 'Còn trống', 3100000);
INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA) VALUES ('P020', 'P210', 'Gia đình', 0, 18, 'Còn trống', 3400000);

-- Dữ liệu cho bảng HOPDONG
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD001', TO_DATE('01-01-2024', 'DD-MM-YYYY'), TO_DATE('01-01-2025', 'DD-MM-YYYY'), 'KT0001', 'P001', 3000000, 4000000, 'Hiệu lực');
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD002', TO_DATE('01-01-2024', 'DD-MM-YYYY'), TO_DATE('01-01-2025', 'DD-MM-YYYY'), 'KT0002', 'P002', 3200000, 4500000, 'Hiệu lực');
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD003', TO_DATE('01-12-2023', 'DD-MM-YYYY'), TO_DATE('01-12-2024', 'DD-MM-YYYY'), 'KT0005', 'P003', 3300000, 4800000, 'Hiệu lực');
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD004', TO_DATE('01-03-2024', 'DD-MM-YYYY'), TO_DATE('01-03-2025', 'DD-MM-YYYY'), 'KT0006', 'P004', 3500000, 5000000, 'Hiệu lực');
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD005', TO_DATE('01-03-2024', 'DD-MM-YYYY'), TO_DATE('01-03-2025', 'DD-MM-YYYY'), 'KT0007', 'P011', 3100000, 4000000, 'Hiệu lực');
INSERT INTO HOPDONG (MHD, NGAYBATDAU, NGAYKETTHUC, MADD, MAP, GIATHUE, TIENCOC, TINHTRANG) VALUES ('HD006', TO_DATE('01-07-2023', 'DD-MM-YYYY'), TO_DATE('01-07-2025', 'DD-MM-YYYY'), 'KT0009', 'P012', 3200000, 4500000, 'Hiệu lực');

-- Dữ liệu cho bảng CTHOPDONG
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD001', 'KT0001');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD001', 'KT0003');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD002', 'KT0002');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD002', 'KT0004');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD003', 'KT0005');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD004', 'KT0006');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD005', 'KT0007');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD005', 'KT0008');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD006', 'KT0009');
INSERT INTO CTHOPDONG (MHD, MAKT) VALUES ('HD006', 'KT0010');


-- Tạo dữ liệu cho bảng HOADON
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0001', 'P001', 1, 2024, 3200000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0002', 'P001', 2, 2024, 4320000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0003', 'P001', 3, 2024, 4380000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0004', 'P001', 4, 2024, 4440000, 'Chưa thanh toán', 4440000);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0005', 'P002', 1, 2024, 4700000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0006', 'P002', 2, 2024, 4760000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0007', 'P002', 3, 2024, 4820000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0008', 'P002', 4, 2024, 4880000, 'Chưa thanh toán', 4880000);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0009', 'P003', 1, 2024, 4800000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0010', 'P003', 2, 2024, 4860000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0011', 'P003', 3, 2024, 4920000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0012', 'P003', 4, 2024, 4980000, 'Chưa thanh toán', 4980000);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0013', 'P004', 1, 2024, 4300000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0014', 'P004', 2, 2024, 4360000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0015', 'P004', 3, 2024, 4420000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0016', 'P004', 4, 2024, 4480000, 'Chưa thanh toán', 4480000);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0017', 'P011', 1, 2024, 4700000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0018', 'P011', 2, 2024, 4760000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0019', 'P011', 3, 2024, 4820000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0020', 'P011', 4, 2024, 4480000, 'Chưa thanh toán', 4480000);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0021', 'P012', 1, 2024, 4340000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0022', 'P012', 2, 2024, 4400000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0023', 'P012', 3, 2024, 4460000, 'Đã thanh toán', 0);
INSERT INTO HOADON (MAHD, MAP, THANG, NAM, TONGTIEN, TRANGTHAI, CONNO) VALUES ('HD0024', 'P012', 4, 2024, 4520000, 'Chưa thanh toán', 4520000);

-- Tạo dữ liệu cho bảng CTHD
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0001', 'Phòng', 1, 3000000, 3000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0001', 'Điện', 200, 5000, 1000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0001', 'Nước', 20, 10000, 200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0002', 'Phòng', 1, 3000000, 3000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0002', 'Điện', 220, 5000, 1100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0002', 'Nước', 22, 10000, 220000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0003', 'Phòng', 1, 3000000, 3000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0003', 'Điện', 230, 5000, 1150000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0003', 'Nước', 23, 10000, 230000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0004', 'Phòng', 1, 3000000, 3000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0004', 'Điện', 240, 5000, 1200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0004', 'Nước', 24, 10000, 240000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0005', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0005', 'Điện', 250, 5000, 1250000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0005', 'Nước', 25, 10000, 250000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0006', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0006', 'Điện', 260, 5000, 1300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0006', 'Nước', 26, 10000, 260000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0007', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0007', 'Điện', 270, 5000, 1350000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0007', 'Nước', 27, 10000, 270000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0008', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0008', 'Điện', 280, 5000, 1400000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0008', 'Nước', 28, 10000, 280000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0009', 'Phòng', 1, 3300000, 3300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0009', 'Điện', 250, 5000, 1250000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0009', 'Nước', 25, 10000, 250000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0010', 'Phòng', 1, 3300000, 3300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0010', 'Điện', 260, 5000, 1300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0010', 'Nước', 26, 10000, 260000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0011', 'Phòng', 1, 3300000, 3300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0011', 'Điện', 270, 5000, 1350000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0011', 'Nước', 27, 10000, 270000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0012', 'Phòng', 1, 3300000, 3300000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0012', 'Điện', 280, 5000, 1400000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0012', 'Nước', 28, 10000, 280000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0013', 'Phòng', 1, 3100000, 3100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0013', 'Điện', 200, 5000, 1000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0013', 'Nước', 20, 10000, 200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0014', 'Phòng', 1, 3100000, 3100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0014', 'Điện', 210, 5000, 1050000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0014', 'Nước', 21, 10000, 210000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0015', 'Phòng', 1, 3100000, 3100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0015', 'Điện', 220, 5000, 1100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0015', 'Nước', 22, 10000, 220000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0016', 'Phòng', 1, 3100000, 3100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0016', 'Điện', 230, 5000, 1150000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0016', 'Nước', 23, 10000, 230000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0017', 'Phòng', 1, 3500000, 3500000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0017', 'Điện', 200, 5000, 1000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0017', 'Nước', 20, 10000, 200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0018', 'Phòng', 1, 3500000, 3500000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0018', 'Điện', 210, 5000, 1050000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0018', 'Nước', 21, 10000, 210000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0019', 'Phòng', 1, 3500000, 3500000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0019', 'Điện', 220, 5000, 1100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0019', 'Nước', 22, 10000, 220000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0020', 'Phòng', 1, 3500000, 3500000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0020', 'Điện', 230, 5000, 1150000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0020', 'Nước', 23, 10000, 230000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0021', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0021', 'Điện', 190, 5000, 950000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0021', 'Nước', 19, 10000, 190000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0022', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0022', 'Điện', 200, 5000, 1000000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0022', 'Nước', 20, 10000, 200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0023', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0023', 'Điện', 210, 5000, 1050000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0023', 'Nước', 21, 10000, 210000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0024', 'Phòng', 1, 3200000, 3200000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0024', 'Điện', 220, 5000, 1100000);
INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN) VALUES ('HD0024', 'Nước', 22, 10000, 220000);

-- Dữ liệu cho bảng DICHVU
INSERT INTO DICHVU (MADV, TENDICHVU) VALUES ('DV001', 'Vòi sen');
INSERT INTO DICHVU (MADV, TENDICHVU) VALUES ('DV002', 'Cửa');
INSERT INTO DICHVU (MADV, TENDICHVU) VALUES ('DV003', 'Ống nước');
INSERT INTO DICHVU (MADV, TENDICHVU) VALUES ('DV004', 'Toilet');
INSERT INTO DICHVU (MADV, TENDICHVU) VALUES ('DV005', 'Đèn');

-- Dữ liệu cho bảng PHIEUDICHVU
INSERT INTO PHIEUDICHVU (MPDV, MAP, SOLUONGDV, NGAYDIEN) VALUES ('PDV001', 'P001', 1, TO_DATE('05-05-2024', 'DD-MM-YYYY'));
INSERT INTO PHIEUDICHVU (MPDV, MAP, SOLUONGDV, NGAYDIEN) VALUES ('PDV002', 'P002', 1, TO_DATE('07-05-2024', 'DD-MM-YYYY'));
INSERT INTO PHIEUDICHVU (MPDV, MAP, SOLUONGDV, NGAYDIEN) VALUES ('PDV003', 'P011', 1, TO_DATE('10-05-2024', 'DD-MM-YYYY'));

-- Dữ liệu cho bảng CTPDV
INSERT INTO CTPDV (MADV, MPDV, TINHTRANG) VALUES ('DV001', 'PDV001', 'Chưa hoàn thành');
INSERT INTO CTPDV (MADV, MPDV, TINHTRANG) VALUES ('DV003', 'PDV002', 'Chưa hoàn thành');
INSERT INTO CTPDV (MADV, MPDV, TINHTRANG) VALUES ('DV005', 'PDV003', 'Chưa hoàn thành');

-- Dữ liệu cho bảng TAIKHOAN
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0001', 'nguyenvana@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0002', 'tranthib@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0003', 'phamvanc@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0004', 'lethid@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0005', 'nguyenvane@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0006', 'tranvanf@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0007', 'lethig@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0008', 'nguyenvanh@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0009', 'phamthii@example.com', '123456', 'Khách thuê');
INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES ('KT0010', 'ranvank@example.com', '123456', 'Khách thuê');

–Tạo khóa chính
ALTER TABLE KHACHTHUE
ADD CONSTRAINT KHACHTHUE_PK PRIMARY KEY 
(
  MAKT
)
ALTER TABLE DICHVU
ADD CONSTRAINT DICHVU_PK PRIMARY KEY 
(
  MADV
)
ALTER TABLE PHIEUDICHVU
ADD CONSTRAINT PHIEUDICHVU_PK PRIMARY KEY 
(
  MPDV 
)
ALTER TABLE HOADON
ADD CONSTRAINT HOADON_PK PRIMARY KEY 
(
  MAHD 
)
ALTER TABLE HOPDONG
ADD CONSTRAINT HOPDONG_PK PRIMARY KEY 
(
  MHD 
)
ALTER TABLE PHONG
ADD CONSTRAINT PHONG_PK PRIMARY KEY 
(
  MAP 
)
ALTER TABLE TAIKHOAN
ADD CONSTRAINT TAIKHOAN_PK PRIMARY KEY 
(
  TENTAIKHOAN 
)
ALTER TABLE KHACHNGANHAN
ADD CONSTRAINT KHACHNGANHAN_PK PRIMARY KEY 
(
  MAKT 
)

–TẠO KHÓA NGOẠI

ALTER TABLE CTHOPDONG 
    ADD CONSTRAINT CTHDONG_MHD_fk
    FOREIGN KEY (MHD) REFERENCES HOPDONG (MHD);    
ALTER TABLE CTHD 
    ADD CONSTRAINT CTHD_MAHD_fk
    FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD);
ALTER TABLE CTPDV 
    ADD CONSTRAINT CTPDV_MPDV_fk
    FOREIGN KEY (MPDV) REFERENCES PHIEUDICHVU (MPDV);
ALTER TABLE HOPDONG 
    ADD CONSTRAINT HDONG_MAP_fk
    FOREIGN KEY (MAP) REFERENCES PHONG (MAP);
ALTER TABLE CTHOPDONG 
    ADD CONSTRAINT CTHDONG_MKT_fk
    FOREIGN KEY (MAKT) REFERENCES KHACHTHUE (MAKT);
ALTER TABLE KHACHNGANHAN
    ADD CONSTRAINT KHACHNGANHAN_MDD_fk
    FOREIGN KEY (MADD) REFERENCES KHACHTHUE (MAKT);
ALTER TABLE HOADON 
    ADD CONSTRAINT HOADON_MAP_fk
    FOREIGN KEY (MAP) REFERENCES PHONG (MAP);
ALTER TABLE HOPDONG 
    ADD CONSTRAINT HDONG_MADD_fk
    FOREIGN KEY (MADD) REFERENCES KHACHTHUE (MAKT);
ALTER TABLE PHIEUDICHVU
    ADD CONSTRAINT PDV_MAP_fk
    FOREIGN KEY (MAP) REFERENCES PHONG (MAP);
ALTER TABLE CTPDV 
    ADD CONSTRAINT CTPDV_MADV_fk
    FOREIGN KEY (MADV) REFERENCES DICHVU (MADV);
ALTER TABLE TAIKHOAN
    ADD CONSTRAINT TAIKHOAN_MAKT_fk
    FOREIGN KEY (MAKT) REFERENCES KHACHTHUE (MAKT);


COMMIT;



    
-- Với khách thuê, khách ngắn hạn, giới tính là nam, nữ 
alter table khachthue 
add constraint khachthue_gioitinh check (gioitinh in ('Nam', 'Nữ'));

-- Với hợp đồng, trạng thái là Chưa hoàn tất, Hiệu lực và Hết hiệu lực
alter table hopdong
add constraint hopdong_trangthai check (tinhtrang in ('Chưa hoàn tất', 'Hiệu lực', 'Hết hiệu lực'));

-- Với hóa đơn, trạng thái là đã thanh toán và chưa thanh toán
alter table hoadon 
add constraint hoadon_trangthai check (trangthai in ('Đã thanh toán', 'Chưa thanh toán'));

-- Với chi tiết hóa đơn, Loại hóa đơn là ‘Phòng’, ‘Điện’ và ‘Nước’
alter table cthd 
add constraint cthd_loaihd check (loaihd in ('Phòng','Điện','Nước'));
-- Với phòng, trạng thái là còn trống và đã cho thuê
alter table phong 
add constraint phong_trangthai check (trangthai in ('Còn trống', 'Đã cho thuê'));

-- Với ctpdv, tình trạng là xử lí và chưa xử lí
alter table ctpdv
add constraint ctpdv_tinhtrang check (tinhtrang in ('Chưa hoàn thành', 'Hoàn thành'))

-- Với khách ngắn hạn, trạng thái là duyệt và chưa duyệt
alter table khachnganhan 
add constraint khachnganhan_trangthai check (trangthai in ('Chờ duyệt','Đã duyệt'));

-- Với CTHD, số lượng, Đơn giá, thành tiền > 0,
alter table cthd 
add constraint cthd_sl_value check (sl > 0);

alter table cthd 
add constraint cthd_dongia_value check (dongia > 0);

alter table cthd 
add constraint cthd_thanhtien_value check (thanhtien > 0);

-- Với Hóa đơn, Tổng tiền > 0
alter table hoadon
add constraint hoadon_tongtien check (tongtien >= 0);

-- Với Phòng, số người, diện tích, giá > 0
alter table phong 
add constraint phong_songuoi_value check (songuoi >= 0);

alter table phong 
add constraint phong_dientich_value check (dientich > 0);

alter table phong 
add constraint phong_gia_value check (gia > 0);

-- Với Phiếu dịch vụ, số lượng dv > 0
alter table phieudichvu
add constraint phieudichvu_soluongdv_value check (soluongdv > 0);

-- Với hợp đồng, tiền cọc > 0
alter table hopdong
add constraint hopdong_tiencoc_value check (tiencoc > 0);

  

--PROCEDURE HỢP ĐỒNG

----------------------------------------------
create or replace procedure proc_gia_han_hop_dong (
    p_mhd_cu hopdong.mhd%type,
    p_ngayketthuc_moi hopdong.ngayketthuc%type,
    p_madd_moi hopdong.madd%type,
    p_map_moi hopdong.map%type,
    p_tiencoc_moi hopdong.tiencoc%type
)
is
    v_ngayketthuc_cu date;

begin
    --Tim ngay ket thuc hop dong cu
    select ngayketthuc 
    into v_ngayketthuc_cu
    from hopdong
    where mhd = p_mhd_cu;
    --Huy hop dong cu
        UPDATE hopdong 
        SET tinhtrang = 'Hết hiệu lực'
        WHERE mhd = p_mhd_cu;

        -- C?p nh?t t?nh tr?ng và s? ngư?i trong ph?ng
        UPDATE phong
        SET 
            trangthai = 'Còn trống', 
            songuoi = 0
        WHERE map IN (
            SELECT map
            FROM hopdong
            WHERE mhd = p_mhd_cu
        );
    --Tao hop dong moi
    proc_them_hop_dong(v_ngayketthuc_cu, p_ngayketthuc_moi, p_tiencoc_moi, p_madd_moi, p_map_moi);

    commit;

    exception
    when others then
        rollback;
        dbms_output.put_line('Đã xảy ra lỗi!');
end;

---------------------------------------------------
create or replace PROCEDURE proc_hoan_tat_hop_dong (
    p_mhd hopdong.mhd%TYPE
)
IS 
    v_ngaybatdau_hopdong DATE;
    v_ngayketthuc_hopdong DATE;
    v_map_hopdong VARCHAR2(100);
    v_songuoi_hopdong NUMBER;
BEGIN 
    -- T?m ngày b?t đ?u, ngày k?t thúc, m? ph?ng trong h?p đ?ng
    SELECT ngaybatdau, ngayketthuc, map
    INTO v_ngaybatdau_hopdong, v_ngayketthuc_hopdong, v_map_hopdong
    FROM hopdong
    WHERE mhd = p_mhd;

    -- C?p nh?t ngày b?t đ?u c?a các khách thuê trong h?p đ?ng
    UPDATE khachthue 
    SET ngaybatdau = v_ngaybatdau_hopdong
    WHERE khachthue.ngaybatdau IS NULL 
    AND khachthue.makt IN (
        SELECT cthopdong.makt
        FROM cthopdong
        WHERE cthopdong.mhd = p_mhd
    );

    -- C?p nh?t ngày k?t thúc c?a các khách thuê trong h?p đ?ng
    UPDATE khachthue 
    SET ngayketthuc = v_ngayketthuc_hopdong
    WHERE khachthue.makt IN (
        SELECT cthopdong.makt
        FROM cthopdong
        WHERE cthopdong.mhd = p_mhd
    ) AND (khachthue.ngayketthuc IS NULL OR khachthue.ngayketthuc < v_ngayketthuc_hopdong);

    -- C?p nh?t t?nh tr?ng c?a ph?ng
    UPDATE phong 
    SET trangthai = 'Đã cho thuê'
    WHERE map = v_map_hopdong;

    -- C?p nh?t t?nh tr?ng h?p đ?ng
    UPDATE hopdong
    SET tinhtrang = 'Hiệu lực'
    WHERE mhd = p_mhd;

    -- T?m s? lư?ng ngư?i trong h?p đ?ng
    SELECT COUNT(*)
    INTO v_songuoi_hopdong
    FROM cthopdong
    WHERE mhd = p_mhd;

    -- C?p nh?t s? lư?ng ngư?i trong ph?ng tương ?ng
    UPDATE phong
    SET songuoi = v_songuoi_hopdong
    WHERE map = v_map_hopdong;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Hoàn t?t h?p đ?ng. M? h?p đ?ng: ' || p_mhd);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Đ? x?y ra l?i!');
END;

---------------------------------------------
create or replace PROCEDURE proc_huy_hop_dong (
    p_mhd hopdong.mhd%TYPE
)
IS
    CURSOR cur_makt IS 
        SELECT makt 
        FROM cthopdong
        WHERE mhd = p_mhd;

    v_makt cthopdong.makt%TYPE;
    v_ngayketthuc_hopdong_trenhat DATE;
BEGIN
    -- C?p nh?t t?nh tr?ng h?p đ?ng
    UPDATE hopdong 
    SET tinhtrang = 'Hết hiệu lực'
    WHERE mhd = p_mhd;

    -- C?p nh?t t?nh tr?ng và s? ngư?i trong ph?ng
    UPDATE phong
    SET 
        trangthai = 'Còn trống', 
        songuoi = 0
    WHERE map IN (
        SELECT map
        FROM hopdong
        WHERE mhd = p_mhd
    );

    OPEN cur_makt;
    LOOP
        FETCH cur_makt INTO v_makt;
        EXIT WHEN cur_makt%NOTFOUND;

        -- T?m ngày k?t thúc h?p đ?ng tr? nh?t c?a khách thuê
        SELECT MAX(hopdong.ngayketthuc)
        INTO v_ngayketthuc_hopdong_trenhat
        FROM hopdong
        JOIN cthopdong ON cthopdong.mhd = hopdong.mhd
        JOIN khachthue ON khachthue.makt = cthopdong.makt
        WHERE hopdong.tinhtrang = 'Hiệu lực' 
        AND cthopdong.makt = v_makt;

        IF v_ngayketthuc_hopdong_trenhat IS NULL THEN 
            -- C?p nh?t ngày k?t thúc c?a các khách trong cthopdong là ngày hi?n t?i
            UPDATE khachthue
            SET ngayketthuc = TRUNC(SYSDATE)
            WHERE khachthue.ngayketthuc > TRUNC(SYSDATE)
            AND khachthue.makt = v_makt;
        ELSE 
            -- C?p nh?t ngày k?t thúc c?a các khách trong cthopdong là ngày k?t thúc h?p đ?ng tr? nh?t
            UPDATE khachthue
            SET ngayketthuc = v_ngayketthuc_hopdong_trenhat
            WHERE khachthue.ngayketthuc > v_ngayketthuc_hopdong_trenhat
            AND khachthue.makt = v_makt;
        END IF;

    END LOOP;
    CLOSE cur_makt;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Đã hủy hợp đồng. Mã hợp đồng: ' || p_mhd);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Đã xảy ra lỗi!');
END;

---------------------------------------
create or replace PROCEDURE XOA_HOPDONG(
  P_MHD CHAR
)
IS
  V_TRANGTHAI_HD VARCHAR2(20);
BEGIN
	--Kiểm trạng tình trạng hợp đồng
  SELECT TINHTRANG INTO V_TRANGTHAI_HD
  FROM HOPDONG
  WHERE MHD = P_MHD;

--Nếu trạng thái hiệu lực thì dừng lại kết thúc.
  IF V_TRANGTHAI_HD = 'Hiệu lực' THEN
    RAISE_APPLICATION_ERROR(-20002, 'Hợp đồng đang ở trạng thái "Hiệu lực" nên không xóa dược!');
  ELSE 

	--Xóa thông tin CTHOPDONG  
    DELETE FROM CTHOPDONG WHERE MHD = P_MHD;

        --Xóa thông tin HOPDONG  
    DELETE FROM HOPDONG WHERE MHD = P_MHD;
    END IF;
  -- Commit changes
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
        ROLLBACK; 
        RAISE;
END XOA_HOPDONG;


-----------------------------------------------
create or replace procedure proc_them_hop_dong (
    p_ngaybatdau in hopdong.ngaybatdau%type, 
    p_ngayketthuc in hopdong.ngayketthuc%type,
    p_tiencoc in hopdong.tiencoc%type,
    p_madd in hopdong.madd%type,
    p_map in hopdong.map%type
)
is 
   v_mhd varchar2(100);
   v_giathue number;
begin
    -- Tao ma hop dong moi
    select 'HD' || lpad(nvl(to_number(substr(max(mhd), 3)), 0) + 1, 3, '0')
    into v_mhd
    from hopdong;

    -- Lay gia thue cua phong
    select gia 
    into v_giathue 
    from phong
    where phong.map = p_map;

    -- Them hop dong moi
    insert into hopdong (mhd, ngaybatdau, ngayketthuc, madd, map, giathue, tiencoc, tinhtrang)
    values (v_mhd, p_ngaybatdau, p_ngayketthuc, p_madd, p_map , v_giathue, p_tiencoc, 'Chưa hoàn tất'); 

    -- Them chi tiet hop dong moi
    insert into cthopdong (mhd, makt) 
    values (v_mhd, p_madd);

    commit;

    dbms_output.put_line('Đã thêm hợp đồng mới. Mã hợp đồng: ' || v_mhd);
exception
    when others then
        rollback;
        dbms_output.put_line('Đã xảy ra lỗi!');
end;

--PROCEDURE CTHDONG

---------------------------------------------------------
create or replace procedure proc_them_chi_tiet_hop_dong (
    p_makt cthopdong.makt%type,
    p_mhd cthopdong.mhd%type
)
is
    v_ngayketthuc_kt date;
    v_ngayhientai date;

begin
    --Lay ngay ket thuc hop dong tuong ung
    SELECT to_date(trunc(sysdate), 'DD-MM-YYYY') into v_ngayhientai 
    FROM DUAL;

    --Tim ngay ket thuc cua khach thue tuong ung
    select ngayketthuc 
    into v_ngayketthuc_kt
    from khachthue
    where makt = p_makt;

     if (v_ngayketthuc_kt is null or  v_ngayketthuc_kt > v_ngayhientai) then
        insert into cthopdong (mhd, makt)
        values (p_mhd, p_makt);
        commit;
        dbms_output.put_line('Đã thêm mã khách thuê ' || p_makt || ' vào hợp đồng ' || p_mhd);
    else 
        commit;
        dbms_output.put_line('Khách đã rời khỏi phòng. Thêm không thành công!');
    end if;    
    exception
    when others then
        rollback;
        dbms_output.put_line('Đã xảy ra lỗi!');
end;

--PROCEDURE KHACHNGANHAN

------------------------------------------------------
create or replace PROCEDURE proc_them_khach_ngan_han (
    p_hoten khachnganhan.hoten%type,
    p_gioitinh khachnganhan.gioitinh%type,
    p_ngaysinh khachnganhan.ngaysinh%type,
    p_sdt khachnganhan.sdt%type,
    p_cccd khachnganhan.cccd%type,
    p_email khachnganhan.email%type,
    p_madd khachnganhan.madd%type,
    p_ngaybatdau khachnganhan.ngaybatdau%type,
    p_ngayketthuc khachnganhan.ngayketthuc%type
)
IS
    v_ma_khachnganhan khachnganhan.makt%type;
    v_check_madd number;
BEGIN
    -- Kiểm tra xem madd có tồn tại trong bảng KHACHTHUE không
    SELECT 'KNH' || LPAD(NVL(TO_NUMBER(SUBSTR(MAX(makt), 4)), 0) + 1, 3, '0')
    INTO v_ma_khachnganhan
    FROM khachnganhan; 

    -- Kiểm tra xem madd có tồn tại trong bảng KHACHTHUE không
    SELECT count(*)
    INTO v_check_madd 
    FROM KHACHTHUE WHERE MAKT = p_madd;

    IF (v_check_madd = 0) THEN 
        DBMS_OUTPUT.PUT_LINE('Khách đại diện thuê không hợp lệ');
        -- Thêm rollback để hủy bỏ thao tác chèn dữ liệu nếu madd không hợp lệ
        ROLLBACK;
        -- Kết thúc procedure nếu madd không hợp lệ
        RETURN;
    END IF;

    -- Chèn dữ liệu mới
    INSERT INTO khachnganhan (makt, hoten, gioitinh, ngaysinh, sdt, cccd, email, madd, trangthai, ngaybatdau, ngayketthuc) 
    VALUES (v_ma_khachnganhan, p_hoten, p_gioitinh, p_ngaysinh, p_sdt, p_cccd, p_email, p_madd, 'Chờ duyệt', p_ngaybatdau, p_ngayketthuc);

    -- COMMIT được di chuyển xuống dưới để đảm bảo rằng chỉ được thực hiện khi không có lỗi
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
    -- Nếu có lỗi, sẽ không thực hiện được ROLLBACK, do đó không cần thêm ROLLBACK ở đây
    ROLLBACK;
    RAISE_APPLICATION_ERROR(-20013, 'Lỗi khi chèn dữ liệu: ' || SQLERRM);

END;

--PROCEDURE HOADON

----------------------------------------
create or replace PROCEDURE them_HoaDon (
  p_thang IN NUMBER,
  p_nam IN NUMBER,
  p_map IN PHONG.MAP%TYPE
)
AS
  v_mahd VARCHAR2(6);
  v_tongtien NUMBER;
  v_conno NUMBER;
BEGIN
	--T? đ?ng t?o m? hóa đơn
  SELECT 'HD' || LPAD(NVL(TO_NUMBER(SUBSTR(MAX(mahd), 3)), 0) + 1, 4, '0') INTO v_mahd
  FROM HOADON;

	--L?y giá ti?n trong ph?ng
 -- SELECT GIA INTO v_tongtien FROM PHONG WHERE MAP = p_map;
	  SELECT GIATHUE INTO v_tongtien FROM HOPDONG WHERE MAP = p_map AND TINHTRANG = 'Hiệu lực';

	--Gán c?n n? cho giá ti?n v?a l?y đư?c
  v_conno := v_tongtien;

	--Thêm thông tin hóa đơn
  INSERT INTO HOADON (mahd, map, thang, nam, tongtien, trangthai, conno)
  VALUES (v_mahd, p_map, p_thang, p_nam, 0 , 'Chưa thanh toán', v_conno);

	--Thêm thông tin chi ti?t hóa đơn
  INSERT INTO CTHD (mahd, loaihd, sl, dongia, thanhtien)
  VALUES (v_mahd, 'Phòng', 1, v_tongtien, v_tongtien);

	--C?p nh?t hóa đơn
  UPDATE HOADON
  SET TONGTIEN= v_tongtien
  WHERE MAHD = v_mahd;

END them_HoaDon;

---------------------------------------
create or replace PROCEDURE XOA_HOADON(
    P_MAHD IN char
)
IS
    V_COUNT NUMBER;
BEGIN
	--Kiểm tra sự tồn tại của mã hóa đơn
    SELECT COUNT(*) INTO V_COUNT FROM HOADON WHERE MAHD = P_MAHD;

	--Nếu không tìm thấy thì kết thúc.
    IF V_COUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Mã hóa đơn không tồn tại');
    END IF;

	--Xóa thông tin CTHD
    DELETE FROM CTHD WHERE MAHD = P_MAHD;

	--Xóa thông tin HOADON
    DELETE FROM HOADON WHERE MAHD = P_MAHD;

    COMMIT; 
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; 
        RAISE; 
END XOA_HOADON;

--CTHD

---------------------------------------
create or replace PROCEDURE THEM_CTHD (
    P_MAHD IN HOADON.MAHD%TYPE,
    P_LOAIHD IN CTHD.LOAIHD%TYPE,
    P_SL IN CTHD.SL%TYPE,
    P_DONGIA IN CTHD.DONGIA%TYPE
) AS
    V_THANHTIEN CTHD.THANHTIEN%TYPE;
BEGIN

	--C?p nh?t thành ti?n m?i       
 V_THANHTIEN := P_SL * P_DONGIA;

	--Thêm thông tin vào CTHD
    INSERT INTO CTHD (MAHD, LOAIHD, SL, DONGIA, THANHTIEN)
    VALUES (P_MAHD, P_LOAIHD, P_SL, P_DONGIA,V_THANHTIEN);

	--C?p nh?t t?ng ti?n trong HOADON
    UPDATE HOADON
    SET TONGTIEN = TONGTIEN + V_THANHTIEN
    WHERE MAHD = P_MAHD;

	--C?p nh?t c?n n? trong HOADON
    UPDATE HOADON
    SET CONNO = CONNO + V_THANHTIEN
    WHERE MAHD = P_MAHD;
END;

-------------------------------------
create or replace PROCEDURE SUA_CTHD ( --chỉ có SL và đơn giá là mới
    P_MAHD IN HOADON.MAHD%TYPE,
    P_LOAIHD IN CTHD.LOAIHD%TYPE,
    P_SL IN CTHD.SL%TYPE,
    P_DONGIA IN CTHD.DONGIA%TYPE,
    P_THANHTIEN IN CTHD.THANHTIEN%TYPE 
) AS
BEGIN



    -- CẬP NHẬT chi ti?t hóa đơn
    UPDATE CTHD SET SL = P_SL, DONGIA = P_DONGIA, THANHTIEN = P_SL*P_DONGIA
    WHERE MAHD = P_MAHD AND LOAIHD = P_LOAIHD;

    -- C?p nh?t t?ng ti?n hóa đơn
    UPDATE HOADON
    SET TONGTIEN = TONGTIEN - P_THANHTIEN + P_SL*P_DONGIA
    WHERE MAHD = P_MAHD;

    -- C?p nh?t c?n n? trong hóa đơn
    UPDATE HOADON
    SET CONNO = CONNO - P_THANHTIEN + P_SL*P_DONGIA
    WHERE MAHD = P_MAHD;
END;

------------------------------------
create or replace PROCEDURE XOA_CTHD (
    P_MAHD IN HOADON.MAHD%TYPE,
    P_LOAIHD IN CTHD.LOAIHD%TYPE,
    P_SL IN CTHD.SL%TYPE,
    P_DONGIA IN CTHD.DONGIA%TYPE
) AS
    V_THANHTIEN CTHD.THANHTIEN%TYPE;
BEGIN

	--L?y ra thành tiên c?a chi ti?t hóa đơn c?n xóa
    SELECT THANHTIEN INTO V_THANHTIEN
    FROM CTHD
    WHERE MAHD = P_MAHD AND LOAIHD = P_LOAIHD AND SL = P_SL AND         DONGIA = P_DONGIA;

    -- Xóa chi ti?t hóa đơn
    DELETE FROM CTHD
    WHERE MAHD = P_MAHD AND LOAIHD = P_LOAIHD AND SL = P_SL AND DONGIA = P_DONGIA;

    -- C?p nh?t t?ng ti?n hóa đơn
    UPDATE HOADON
    SET TONGTIEN = TONGTIEN - V_THANHTIEN
    WHERE MAHD = P_MAHD;

    -- C?p nh?t c?n n? trong hóa đơn
    UPDATE HOADON
    SET CONNO = CONNO - V_THANHTIEN
    WHERE MAHD = P_MAHD;
END;

--PROCEDURE DICHVU

---------------------------------------
create or replace procedure Them_Dichvu(
    p_dichvu_ten dichvu.tendichvu%type
)
is 
    v_madv varchar2(100);
    v_count number;
begin 
-- kiểm tra tên dịch vụ tồn tại chưa
    select count(*) 
    into v_count
    from dichvu 
    where tendichvu = p_dichvu_ten;
    if (v_count = 0) then 
    -- Tao ma hop dong moi
    select 'DV' || lpad(nvl(to_number(substr(max(madv), 3)), 0) + 1, 3, '0')
    into v_madv
    from dichvu;

    --Them dich vu moi
    insert into dichvu (madv, tendichvu) 
    values (v_madv, p_dichvu_ten);
    commit;
    else 
        -- Thông báo có lỗi
        dbms_output.put_line('Tên dịch vụ đã tồn tại');
        commit;
    end if;


    dbms_output.put_line('Đã thêm dịch vụ mới. Mã dịch vụ: ' || v_madv);
end;

---------------------------------------
create or replace procedure Sua_Dichvu (
    p_dichvu_id dichvu.madv%type,
    p_dichvu_tendichvu dichvu.tendichvu%type
)
is 
    v_count number;
    v_count2 number;
begin
    -- Kiểm tra mã dịch vụ có tồn tại không
    select count(*) 
    into v_count
    from dichvu 
    where madv = p_dichvu_id;
    --kiểm tra tên dịch vụ có tồn tại chưa
    select count(*) 
    into v_count2
    from dichvu 
    where tendichvu = p_dichvu_tendichvu;

    if (v_count > 0) then 
        if (v_count2 = 0) then
            -- Cập nhật dịch vụ nếu mã dịch vụ tồn tại
            update dichvu
            set tendichvu = p_dichvu_tendichvu
            where madv = p_dichvu_id;
            commit; 
            dbms_output.put_line('Cập nhật dịch vụ có mã dịch vụ: ' || p_dichvu_id || ' thành công!');
        else  
            dbms_output.put_line('Tên dịch vụ đã tồn tại');
        end if;    
    else 
        -- Thông báo có lỗi
        dbms_output.put_line('Mã dịch vụ không tồn tại');
        commit;
    end if;
end;

---------------------------------------
create or replace PROCEDURE XOA_DICHVU(
    P_MADV IN DICHVU.MADV%TYPE
)
IS
    V_COUNT NUMBER;
    V_COUNT_1 NUMBER;
BEGIN

    --Kiểm tra sự tồn tại của mã dịch vụ
    SELECT COUNT(*) INTO V_COUNT FROM DICHVU WHERE MADV = P_MADV;

    --Nếu không tìm thấy thì kết thúc.
    IF V_COUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Mã dịch vụ không tồn tại.');
    END IF;


    -- Kiểm tra xem có phiếu dịch vụ nào hoàn tất chưa
    SELECT COUNT(*) 
    INTO V_COUNT_1
    FROM CTPDV 
    WHERE MADV = P_MADV
    AND TINHTRANG = 'Chưa hoàn thành';

    IF (V_COUNT_1 = 0) THEN 
        --Xóa thông tin CTPDV
        DELETE FROM CTPDV WHERE MADV = P_MADV;
        --Xóa thông tin DICHVU  
        DELETE FROM DICHVU WHERE MADV = P_MADV;
    ELSE 
        RAISE_APPLICATION_ERROR(-20002,'Không thể xóa dịch vụ vì còn đang sử dụng');
    END IF;

    COMMIT;

    -- Thông báo thành công
    DBMS_OUTPUT.PUT_LINE('Xóa dịch vụ thành công!');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; 
        RAISE; 
END XOA_DICHVU;

--PROCEDURE PHIEUDICHVU

---------------------------------------------
create or replace PROCEDURE XOA_PHIEU_DICH_VU(
    P_MPDV IN PHIEUDICHVU.MPDV%TYPE
)
IS
    V_COUNT NUMBER;
    V_COUNT_1 NUMBER;
BEGIN
    --Kiểm tra sự tồn tại của mã phiếu dịch vụ
    SELECT COUNT(*) INTO V_COUNT FROM PHIEUDICHVU WHERE MPDV = P_MPDV;

    --Nếu không tìm thấy thì kết thúc.
    IF V_COUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Mã phiếu dịch vụ không tồn tại.');
    END IF;

    -- Kiểm tra xem có phiếu dịch vụ nào hoàn tất chưa
    SELECT COUNT(*) 
    INTO V_COUNT_1
    FROM CTPDV 
    WHERE MPDV = P_MPDV
    AND TINHTRANG = 'Chưa hoàn thành';

    IF (V_COUNT_1 = 0) THEN 
        --Xóa thông tin CTPDV
        DELETE FROM CTPDV WHERE MPDV = P_MPDV;
        --Xóa thông tin PHIEUDICHVU  
        DELETE FROM PHIEUDICHVU WHERE MPDV = P_MPDV;
    ELSE 
        RAISE_APPLICATION_ERROR(-20002,'Không thể xóa dịch vụ vì còn đang sử dụng');
    END IF;

    COMMIT; 

    DBMS_OUTPUT.PUT_LINE('Xóa phiếu dịch vụ thành công!');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; 
        RAISE;
END XOA_PHIEU_DICH_VU;

--PROCEDURE KHACHTHUE

------------------------------------------
create or replace PROCEDURE ThemKhachThue (
    p_Ten IN VARCHAR2,
    p_GioiTinh IN VARCHAR2,
    p_NgaySinh IN DATE,
    p_SDT IN VARCHAR2 DEFAULT NULL,
    p_CCCD IN VARCHAR2 DEFAULT NULL,
    P_Email IN VARCHAR2 DEFAULT NULL
)
IS
    v_MaKT CHAR(6);
BEGIN
    -- T?o t? đ?ng m? khách thuê 
   SELECT 'KT' || LPAD(NVL(TO_NUMBER(SUBSTR(MAX(MAKT), 3)), 0) + 1, 4, '0') INTO v_MaKT
   FROM KHACHTHUE;
    -- Thêm d?  li?u vào b?ng KHACHTHUE
    INSERT INTO KHACHTHUE (MAKT, HOTEN, GIOITINH, NGAYSINH, SDT, CCCD, EMAIL)
    VALUES (v_MaKT, p_Ten, p_GioiTinh, p_NgaySinh, p_SDT, p_CCCD, p_Email);
    -- nếu email khác null thì thêm tài khoản với mật khẩu là 123456 và tài khoản là email của khách
    if (P_Email IS NULL) then
    DBMS_OUTPUT.PUT_LINE('Loi');
    else
    INSERT INTO TAIKHOAN (MAKT, TENTAIKHOAN, MATKHAU, VAITRO) VALUES (v_MaKT, p_Email, '123456', 'Khách thuê');

    end if;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('L?i: ' || SQLERRM);
END;

create or replace PROCEDURE XOA_KHACH (p_MAKT IN CHAR)
IS
  v_HOPDONG_COUNT NUMBER;
BEGIN
--Ki?m tra tr?ng ph?ng
  SELECT COUNT(*) INTO v_HOPDONG_COUNT
  FROM HOPDONG HD, CTHOPDONG CT
  WHERE CT.MAKT = p_MAKT AND TINHTRANG = 'Hiệuu lựcc' AND HD.MHD = CT.MHD;

	--N?u t?nh tr?ng h?t hi?u l?c th?
  IF v_HOPDONG_COUNT = 0 THEN 

	--Xóa thông tin CTHOPDONG
    DELETE FROM CTHOPDONG WHERE MHD IN (SELECT MHD FROM HOPDONG WHERE MADD = p_MAKT);

	-- Xóa thông tin HOPDONG
    DELETE FROM HOPDONG WHERE MADD = p_MAKT;

	--Xóa thông tin KHACHNGANHAN
    DELETE FROM KHACHNGANHAN WHERE MAKT = p_MAKT;

	-- Xóa thông tin KHACHTHUE
    DELETE FROM KHACHTHUE WHERE MAKT = p_MAKT;
    COMMIT;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
END XOA_KHACH;

--PROCEDURE PHONG

-------------------------------------
create or replace PROCEDURE ThemPhong (
    p_TenPhong IN VARCHAR2,
    p_LoaiPhong IN VARCHAR2,
    p_DienTich IN NUMBER,
    p_GiaThue IN NUMBER
)
IS
    v_MaPhong CHAR(4);
BEGIN
    -- T?o m? ph?ng t? đ?ng
   SELECT 'P' || LPAD(NVL(TO_NUMBER(SUBSTR(MAX(MAP), 3)), 0) + 1, 3, '0') INTO v_MaPhong
   FROM PHONG;
    -- Thêm d? li?u vào b?ng PHONG
    INSERT INTO PHONG (MAP, TENPG, LOAI, SONGUOI, DIENTICH, TRANGTHAI, GIA)
    VALUES (v_MaPhong, p_TenPhong, p_LoaiPhong, 0, p_DienTich, 'Còn trống', p_GiaThue);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('L?i: ' || SQLERRM);
END;

-------------------------------------
create or replace PROCEDURE XOA_PHONG(
  P_MAP CHAR
)
AS
  V_TRANGTHAI_PHONG VARCHAR2(20);
BEGIN

	--L?y thông tin t?nh tr?ng ph?ng
  SELECT TRANGTHAI INTO V_TRANGTHAI_PHONG
  FROM PHONG
  WHERE MAP = P_MAP;

	--Ki?m tra t?nh tr?ng ph?ng
  IF V_TRANGTHAI_PHONG != 'Còn trống' THEN
    RAISE_APPLICATION_ERROR(-20002, 'Phòng phải trạng thái "Còn trống" mới xóa được!');

  ELSE
	--Xóa thông tin h?p đ?ng
  DELETE FROM HOPDONG WHERE MAP = P_MAP;

	--Xóa thông tin hóa đơn
  DELETE FROM HOADON WHERE MAP = P_MAP;

	--Xóa thông tin phi?u d?ch v?
  DELETE FROM PHIEUDICHVU WHERE MAP = P_MAP;

	--Xóa thông tin ph?ng
  DELETE FROM PHONG WHERE MAP = P_MAP;

  END IF;
  COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; 
        RAISE;
END XOA_PHONG;

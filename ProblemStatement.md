# Introduction #
## (Bản dịch tiếng việt cho dễ hiểu) ##

Mohan Ltd. là một thư viện được quản lý bằng tay bởi Ms. Monica. Tất cả các thông tin đều được ghi bằng giấy và Monica tìm thông tin rất khó khăn để quản lý khi một ai đó trả sách.Cô ấy đã duy trì 1 danh sách các thông tin về sách như tác giả, tên sách....Khi một cuốn sách được trả cô ấy phải tìm bằng tay cuốn sách đó và lại có người mượn có ấy lại ghi lại những người đăng ký mượn với thông tin về sách như tên sách, tác giả, nhân viên mượn (tên, phòng ban...), ngày mượn, ngày trả....Quá trình đó thật buồn tẻ và tốn thời gian. Cô ấy đã mang vấn đề đấy đến những lập trình viên có kinh nghiệm và họ đề xuất sẽ giải quyết vấn đề đấy bằng cách phát triển 1 hệ thống giúp Monica quản lý có hiệu quả và tiết kiệm thời gian cho cô ấy. Cô ấy sẽ chỉ là người dùng của hệ thống quản lý.OK?

# Requirement Summary #

Tùy thuộc vào quyết định thực hiện tin học hoá toàn bộ hoạt động quản lý thư viện, một hệ thống sẽ được phát triển dựa trên những yêu cầu sau.
  1. Thêm thông tin về nhân viên. Mỗi nhân viên sẽ có các thuộc tính sau:
    * Employee ID(unique)
    * Name
    * Address
    * Phone Number
    * Department
  1. Một ID duy nhất sẽ được tao ra ngay bên trong mỗi nhân viên
  1. Update/Delete mỗi hồ sơ nhân viên
    * Mỗi hồ sơ sẽ được chọn lựa bằng việc sử dụng Employee ID
    * Mỗi hồ sơ có thể được xóa nếu không có quyển sách nào được mượn bởi người dùng.
  1. Thêm vào một quyển sách. Mỗi quyển sách phải bao gồm những thuộc tính sau:
    * Call Number
    * ISBN/Name of book
    * Title
    * Author name
  1. Call number được đề nghị phải theo nguyên tắc sau:
    * (2 chữ cái đầu tiên của Title) - (2 chữ cái đầu tiên của tên tác giả) - dãy số của cuốn sách (tạm hiểu là số thứ tự của cuốn sách).
    * XX-XX-NNN (tạm hiểu là XX là chữ còn NN là number)
  1. ISBN được đề nghị phải theo nguyên tắc sau:
    * (Mã số của Subject) - (dãy số của cuốn sách - kiểu như là số thứ tự)
    * NNN-NNNN - Nó phải là duy nhất cho mỗi sự kết hợp của tiêu đề sách và tên tác giả.
  1. Tên tác giả phải hỗ trợ tối đa 30 chars.
  1. Tiêu đề sách hộ trợ tối đa 100 chars.
  1. Update/Delete một cuôn sách.
    * Một cuốn sách có thể được tìm bằng call number
    * Dữ liệu của cuốn sách có thể update bao gồm:
      * ISBN
      * Title
      * Author Name
  1. Quyển sách có thể được xóa chỉ khi nó chưa được mượn bởi thằng nào.
  1. Truy vấn trong database
    * Hệ thống sẽ để quản lý thư viện truy vấn thông tin sách bởi ISBN hoặc là Author hoặc là Title
    * Kết quả tìm kiếm cũng sẽ tạo ra một danh sách các sách, nó phù hợp với các thông số tìm kiếm với các chi tiết sau đây:
      * Call number
      * ISBN number
      * Title
      * Author
    * Màn hình hiển hị sẽ bao gồm cả số bản copy còn lại (có sẵn, tức là đã trừ đi số được mượn) có thể cho mượn
    * Màn hình hiển thị sẽ cung cấp một phương tiện để chọn một hay nhiều hàng vào một danh sách người dùng.
    * Xem chi tiết mỗi cuốn sách sẽ cung cấp thông tin về trạng thái check-in/check-out (cái này có thể hiểu là đã phát cho mượn/ đã trả lại sách), với thông tin của người mượn.
    * Kết quả tìm kiếm sẽ hạn chế khoảng 20 kết quả/ 1 trang và sẽ có thanh điều hướng cho các kết qủa tìm kiếm (next/previous).
    * Người dùng có thể thực hiện tìm kiếm nhiều trước khi lựa chọn một bộ sách cho check-in hoặc check-out. Những nên lưu trữ qua kết quả tìm kiếm.
  1. Check - Out a book
    * Quản lý thư viện có thể phát sách (check-out) bằng việc sử dụng call number (của quyển sách)
    * Phát sách (check-out) có thể được bắt đầu từ một hoạt động tìm kiếm trước đó lúc mà người dùng đã lựa chọn một bộ sách.
    * Mã số nhân viên, người mà sẽ mượn quyển sách phải được nhập vô.
    * Ngày phát sách sẽ tự động được tạo ra dựa vào ngày hệ thống hiện hành.
    * Ngày hết hạn sẽ tự động được đánh dấu là 5 ngày, kể từ hiện phát sách.
  1. Check - In a book
    * Quản lý thư viện có thể thực hiện trả sách (check-in) bằng việc sử dụng call number (của quyển sách)
    * Trả sách (check-in) có thể được bắt đầu từ một hoạt động tìm kiếm trước đó lúc mà người dùng đã lựa chọn một bộ sách.
    * Ngày trả sách sẽ tự động được tạo ra dựa vào ngày hệ thống hiện hành.
    * Bất kỳ khoản phí trả muộn sẽ được tính như giữa ngày hết hạn và ngày trở lại ở mức 10 cent một ngày.
  1. Hiển thị thông tin sách.
    * Mục này sẽ hiển thị chi tiết về một cuốn sách được lựa chọn từ hoạt động tìm kiếm
    * Thông tin hiển thị sẽ bao gồm:
      1. Call number
      1. ISBN
      1. Title
      1. Author
      1. Issue status(In library or checked - out)
      1. If book is checked out it would display:
        1. User ID & Name
        1. Checkout date
        1. Due-date
  1. Hiển thị thông nhân viên.
    * Quản lý thư viện có thể chọn hồ sơ nhân viên để xem
    * Thông tin hiển thị bao gồm:
      * Usename, ID, Address và Phone number
      * Những cuốn sách được mượn bởi nhân viên với ngày mượn, due-date, call number, title
      * Phí cuối cùng và tiền phạt cùng với tổng tiền
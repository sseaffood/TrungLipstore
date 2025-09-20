/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.article;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 84904
 */
public class ArticleDAO {
    public List<ArticleDTO> getAllArticle() {
        List<ArticleDTO> list = new ArrayList<>();
        list.add(new ArticleDTO("1", "Dùng son nhiều có bị thâm môi?", "Nhiều người cho rằng môi thâm là do lạm dụng son, không tẩy trang sạch mỗi ngày. Như vậy, dùng son môi thường xuyên có khiến môi thâm không? (Lan, 22 tuổi)\n" +
                                                                        "\n" +
                                                                        "Trả lời:\n" +
                                                                        "\n" +
                                                                        "Cục Quản lý Thực phẩm và Dược phẩm Mỹ (FDA) khuyến cáo nồng độ chì hoặc các kim loại nặng tiêu chuẩn trong son nên thấp hơn 10 ppm. Nếu son hoặc một loại sản phẩm, mỹ phẩm nào có nồng độ chì, kim loại nặng cao hơn mức quy định trên thì không nên sử dụng.\n" +
                                                                        "\n" +
                                                                        "Nguyên nhân là chì trong son dễ gây ra tình trạng thay đổi sắc tố của môi. Ngoài ra, thoa những loại son có chứa chất gây kích ứng vô tình sẽ khiến môi chúng ta gặp hiện tượng viêm, sau đó dẫn đến tình trạng tăng sắc tố viêm, khiến môi thâm hơn. Các loại son giả, son không rõ nguồn gốc khiến môi thâm và ảnh hưởng đến sức khỏe.\n" +
                                                                        "\n" +
                                                                        "Môi cũng là một vị trí khá nhạy cảm do da ở vùng này khá mỏng. Do đó, kể cả dùng son đắt tiền, thương hiệu lớn vẫn có thể bị dị ứng.\n" +
                                                                        "\n" +
                                                                        "Để đảm bảo an toàn, bạn không nên mua những loại son giá rẻ, không rõ nguồn gốc vì khó xác định các thành phần. Đối với son chính hãng, cần đọc kỹ bảng thành phần để giảm tình trạng kích ứng và đảm bảo nồng độ chì đạt tiêu chuẩn. Nên mua son ở địa chỉ uy tín để tránh tình trạng mua giá cao nhưng sản phẩm không chất lượng.\n" +
                                                                        "\n" +
                                                                        "Một số biện pháp khác để chăm sóc môi như tẩy tế bào chết từ một đến hai lần mỗi tuần. ‏Massage môi nhẹ nhàng, dùng son dưỡng để tránh khô môi, giúp môi mịn màng. ‏\n" +
                                                                        "\n" +
                                                                        "Bác sĩ Nguyễn Phương Thảo\n" +
                                                                        "Khoa Da liễu - Thẩm mỹ Da\n" +
                                                                        "Bệnh viện Đại học Y Dược TP HCM"));
        list.add(new ArticleDTO("2", "Xu hướng son môi, nước hoa nói gì về kinh tế thế giới", "Doanh số son môi năm suy thoái kinh tế 2001 tăng vọt và điều tương tự diễn ra với các loại kem nền trong cuộc khủng hoảng tài chính 2008.\n" +
                                                                                                "\n" +
                                                                                                "Thuật ngữ Chỉ số Son môi lần đầu được đưa ra trong suy thoái năm 2001 bởi Leonard Lauder – Chủ tịch hãng mỹ phẩm Estee Lauder khi đó. Ông nói rằng doanh số son môi mùa thu năm đó tăng vọt, cho thấy phụ nữ đang đối mặt với tương lai kinh tế thiếu chắc chắn, nên tìm đến mỹ phẩm để giải tỏa áp lực.\n" +
                                                                                                "\n" +
                                                                                                "Đến khủng hoảng tài chính 2008 – 2009, tới Chỉ số Kem nền xuất hiện, khi phụ nữ thời kỳ này chuộng làn da hoàn hảo hơn là môi đẹp.\n" +
                                                                                                "\n" +
                                                                                                "Còn năm nay, Andrea Felsted - cây viết về hàng tiêu dùng và bán lẻ trên Bloomberg Opinion - cho rằng thế giới hãy sẵn sàng cho Chỉ số Nước hoa. Nước hoa hoặc đồ chăm sóc tóc có thể phản ánh tốt hơn sự chuyển hướng của người dùng từ các sản phẩm xa xỉ sang hàng hóa vừa túi tiền hơn hậu đại dịch.\n" +
                                                                                                "\n" +
                                                                                                "Dĩ nhiên, doanh số sản phẩm trang điểm vẫn đang bùng nổ. Son môi vẫn là một trong những mặt hàng dẫn đầu tại cả Mỹ và châu Âu, cả phân khúc phổ thông lẫn cao cấp.\n" +
                                                                                                "\n" +
                                                                                                "Tuy nhiên, nhu cầu mỹ phẩm không chỉ giới hạn ở son môi. Nhiều người đã không trang điểm trong suốt thời gian ở nhà vì đại dịch. Sản phẩm chăm sóc da, vốn đã vượt qua đồ trang điểm vài năm qua, vì thế càng trở nên quan trọng."));
        list.add(new ArticleDTO("3", "Chọn màu son hợp mùa hè", "Các tông son đỏ, đỏ cam, cam san hô hoặc cam đất mang lại cảm giác tươi mát, trẻ trung, dễ kết hợp của nhiều layout make-up năng động.\n" +
                                                                "\n" +
                                                                "Tùy tông make-up, phong cách và màu trang phục mà chị em có thể lựa chọn các màu son phù hợp đi kèm để gương mặt thêm rạng rỡ. Mùa hè là thời điểm lý tưởng cho những màu son nổi bật như đỏ, đỏ cam, cam san hô, cam đào... vì mang lại cảm giác trẻ trung, năng động nhưng không kém phần rạng rỡ. Dưới đây là một số thỏi son kem, son lì bán chạy trên Shop VnExpress, hiện có giá ưu đãi sâu nhân dịp hè về."));
        list.add(new ArticleDTO("4", "Gợi ý màu son cho nàng công sở", "Những màu son cơ bản như hồng, đỏ, cam... pha chút tông đất giúp gương mặt chị em thêm rạng rỡ chốn văn phòng.\n" +
                                                                        "\n" +
                                                                        "Để không mắc lỗi trang điểm, chọn nhầm son không phù hợp với tông da hay trang phục, chị em nên lưu ý một số đặc điểm về màu son.\n" +
                                                                        "\n" +
                                                                        "Son đỏ\n" +
                                                                        "\n" +
                                                                        "Đỏ luôn là sắc son tiêu biểu giúp phụ nữ thêm phần quyến rũ, nổi bật giữa đám đông. Màu đỏ cũng rất dễ sử dụng, nhất là với những nàng chưa thành thạo make-up. Bởi chỉ cần tô chút son đỏ, chị em đã có thể tự tin xuống phố mà không cần trang điểm quá đậm.\n" +
                                                                        "\n" +
                                                                        "Đỏ cũng có nhiều sắc thái khác nhau, pha trộn với những tông màu khác, thể hiện cá tính riêng. Với những nàng cá tính mạnh, theo đuổi phong cách quyến rũ, chững chạc, có thể thử tông đỏ truyền thống, đỏ tươi hoặc trầm đều được.\n" +
                                                                        "\n" +
                                                                        "Một trong những sắc đỏ đang được ưa chuộng là đỏ đất. Không rực rỡ như đỏ tươi, cũng không quá già dặn như đỏ thẫm, đỏ đất mang lại nét rạng rỡ trang nhã rất riêng. Phái đẹp có thể tô son đỏ đất đi làm mỗi ngày mà không sợ bị nhiều ánh mắt nhìn ngó.\n" +
                                                                        "\n" +
                                                                        "Son hồng\n" +
                                                                        "\n" +
                                                                        "Đây là tông son dành cho những cô nàng theo phong cách nữ tính, tiểu thư. Trái ngược với sự táo bạo của son đỏ, son hồng mang lại cảm giác nền nã, dịu dàng. Chị em có thể tô son hồng san hô hoặc hồng đất trong những buổi họp công ty hoặc gặp gỡ đối tác. Màu son này giúp gương mặt trông rạng rỡ hơn nhiều mà vẫn lịch sự, không bị cho là quá \"lố\".\n" +
                                                                        "\n" +
                                                                        "Son cam\n" +
                                                                        "\n" +
                                                                        "Cam luôn là màu son lý tưởng cho những nàng da nâu năng động. Chẳng phải tự nhiên mà son cam được xem là một trong những màu son đại diện cho mùa hè sôi động. Nhưng vì son cam có xu hướng làm răng vàng đi, khi chọn màu này, chị em nên chú ý vệ sinh răng để răng luôn trắng sáng, thêm phần tự tin.\n" +
                                                                        "\n" +
                                                                        "Trái lại, nếu chị em có màu răng tự nhiên hơi ngả vàng, có thể thử sức với tông cam đất. Đây là màu son rất được ưa chuộng tại Hàn Quốc. Phái đẹp xứ kim chi thường dùng son cam đất trong tất cả sự kiện và thời điểm trong ngày vì sự \"đa năng\" và phù hợp mọi nơi mọi lúc."));
        list.add(new ArticleDTO("5", "Gợi ý màu son nữ hợp với từng hoàn cảnh", "Tùy theo điểm đến, thời gian, đối tượng gặp mặt mà phái đẹp chọn màu son phù hợp, giúp gương mặt thêm rạng rỡ, nổi bật phong cách, cá tính.\n" +
                                                                                "\n" +
                                                                                "Son môi là một trong những \"vũ khí bí mật\" giúp gương mặt nữ giới thêm phần rạng rỡ, gia tăng sự tự tin khi tiếp xúc gần với người đối diện. Ngoài điểm đến, thời gian, đối tượng gặp mặt là ai... thì độ tuổi, tông da và màu trang phục cũng ảnh hưởng đến quyết định chọn màu son.\n" +
                                                                                "\n" +
                                                                                "Để tiết kiệm thời gian, các nàng có thể chọn màu trang phục trước, sau đó quyết định kiểu make-up hoặc màu son đi kèm để không bị lạc điệu. Dưới đây là một số màu son cơ bản, thường được các chị em sử dụng hàng ngày hoặc vào những dịp đặc biệt.\n" +
                                                                                "\n" +
                                                                                "Son đỏ\n" +
                                                                                "\n" +
                                                                                "Đây là một trong những màu cơ bản mà chị em nên sở hữu ít nhất một thỏi. Son đỏ còn có nhiều sắc thái đậm, nhạt, tươi, trầm hoặc hòa trộn với những tông màu khác như cam, tím, hồng...\n" +
                                                                                "\n" +
                                                                                "Son đỏ đại diện cho sự quyến rũ, cuốn hút. Sắc đỏ nổi bật sẵn và thường đập vào mắt người đối diện ngay lần đầu gặp mặt, tuy nhiên, chị em nên tiết chế, không nên make-up mắt và má hồng quá đậm.\n" +
                                                                                "\n" +
                                                                                "Những tông đỏ được chị em ưa chuộng gồm đỏ tươi, đỏ đất, đỏ cam... Son đỏ vẫn phù hợp tô đi làm, nhưng tránh tô quá đậm, dễ khiến bản thân trở nên lòe loẹt, thiếu chuyên nghiệp chốn công sở.\n" +
                                                                                "\n" +
                                                                                "Son cam, cam san hô\n" +
                                                                                "\n" +
                                                                                "Nếu son đỏ được xem là sắc son huyền thoại chưa bao giờ lỗi mốt thì son cam mang đến cảm giác tươi mới. Son cam phù hợp với những nàng da ngăm, giúp tôn làn da bánh mật cá tính. Nếu không tự tin diện son đỏ, chị em chỉ cần tô chút son cam hoặc cam san hô, sẽ khiến gương mặt tươi tắn hơn nhiều.\n" +
                                                                                "\n" +
                                                                                "Kiểu make-up cho son cam hiện nay khá đa dạng. Các nàng có thể make-up mắt với tông màu nâu nhạt hoặc vàng đồng, màu cam, hồng đào... đều hợp. Phái đẹp Hàn Quốc thời gian qua còn ưu ái kiểu make-up ngây thơ, căng tràn sức sống như quả đào hay quả mơ với tông cam làm chủ đạo. Kiểu make-up này sẽ giúp bạn trông trẻ trung và năng động hơn.\n" +
                                                                                "\n" +
                                                                                "Son hồng\n" +
                                                                                "\n" +
                                                                                "Đây là màu son lý tưởng và quen thuộc với những nàng theo đuổi phong cách nhẹ nhàng, nữ tính, tiểu thư và ngọt ngào. Khác với vẻ quyến rũ của son đỏ và năng động, rực rỡ của son cam, son hồng cho cảm giác thanh thoát và tự nhiên. Màu son này có thể sử dụng ở mọi địa điểm, vào bất cứ thời gian nào và phù hợp với hầu hết các kiểu trang phục."));
        list.add(new ArticleDTO("6","Cách chọn son môi","Đặc điểm làn da, chất son, dáng môi... là những điều cần quan tâm để chọn được thỏi son phù hợp cho chính mình.\n" +
                                                        "\n" +
                                                        "Sắc da\n" +
                                                        "\n" +
                                                        "Chọn son môi phù hợp sẽ tôn lên màu da, giúp bạn nổi bật và quyến rũ hơn. Nếu làn da trắng, bạn có nhiều lựa chọn, nhưng phù hợp nhất vẫn là các gam màu sáng, nude hoặc nâu nhẹ để khoe cá tính.\n" +
                                                        "\n" +
                                                        "Tông trung bình nên ưu tiên đỏ, cam, hạn chế màu tím hoặc hồng đậm. Làn da ngăm có thể chọn đỏ sậm, hồng đậm để trông quyến rũ hơn, tuy nhiên đừng chọn các màu quá tối."
                                                                        + "Chất liệu\n" +
                                                        "\n" +
                                                        "Khi mua son, nên chú ý đến chất liệu để có cách sử dụng phù hợp. Ví dụ son dạng kem vừa có tác dụng tạo màu lại dưỡng da môi, nên dùng cọ để tán đều son trên môi.\n" +
                                                        "\n" +
                                                        "Son lì có đặc tính lâu phai, bền màu, hạn chế việc phải dặm màu môi. Tuy nhiên bạn cần dùng thêm sản phẩm dưỡng để tránh khô, bong tróc da môi.\n" +
                                                        "\n" +
                                                        "Các loại son dưỡng ẩm được nhiều phụ nữ lựa chọn nhờ công dụng giữ cho đôi môi mềm mại, không nứt nẻ. Son bóng phù hợp với người có làn môi khô. \n" +
                                                        "\n" +
                                                        "Dáng môi\n" +
                                                        "\n" +
                                                        "Người có làn môi mỏng nên chọn các màu son tươi sáng như hồng cam, hồng đào... Ngược lại, đôi môi dày sẽ ấn tượng và nổi bật hơn khi dùng son tông đỏ. Nếu da môi sậm màu, nên chọn son có ánh kim để làm bật tông." ));
        list.add(new ArticleDTO("7", "Son môi từ những độc chất của phái đẹp thời cổ đại", "Phụ nữ Ai Cập cổ đại nghiền nát đá quý bôi lên môi hoặc nghiền kiến đỏ, bọ cánh cứng trộn với nước ép giúp môi đỏ mọng.\n" +
                                                                                            "\n" +
                                                                                            "Từ nghìn năm trước, con người đã quan tâm đến việc làm đẹp, đặc biệt là tô son môi đỏ. Đôi môi đỏ ban đầu để phân biệt quý tộc với các tầng lớp thấp hơn, sau này trở thành cách trang điểm. Công thức chế tạo son môi thời cổ đại bao gồm những thành phần kỳ lạ.\n" +
                                                                                            "\n" +
                                                                                            "Ai Cập cổ đại\n" +
                                                                                            "\n" +
                                                                                            "Phụ nữ Ai Cập cổ đại rất thích tô son màu đỏ. Bức tượng bán thân nổi tiếng của nữ hoàng Nefertiti với đôi môi màu đỏ của bà trở thành một ví dụ mang tính biểu tượng cho vẻ đẹp nữ tính. Các tài liệu lịch sử ghi chép cách mà người Ai Cập cổ đại dùng là nghiền nát hồng ngọc và các loại đá quý khác, trộn với chì trắng bôi lên môi.\n" +
                                                                                            "\n" +
                                                                                            "Nữ hoàng Cleopatra VII chế son môi từ kiến đỏ và bọ cánh cứng nghiền nát, trộn với nước ép quả giúp  đỏ mọng môi. Nếu muốn thêm phần tỏa sáng, bà trộn các thành phần này với vảy cá nhỏ. Các nhà khoa học đánh giá nhiều hợp chất và nọc độc côn trùng trong công thức này khá nguy hiểm."
                                                                                                            + "Hy Lạp cổ đại\n" +
                                                                                            "\n" +
                                                                                            "Người Hy Lạp cổ đại quan tâm đến tóc giả và thuốc nhuộm tóc hơn là tô son môi. Chỉ những cô gái hành nghề mại dâm mới tô son môi đỏ. Công thức chế tạo son thời kỳ này gồm thuốc nhuộm đỏ và rượu vang kết hợp với một số thành phần khá kỳ lạ như mồ hôi cừu, nước bọt con người hay phân cá sấu. \n" +
                                                                                            "\n" +
                                                                                            "Thời trung cổ\n" +
                                                                                            "\n" +
                                                                                            "Trong thời trung cổ, người ta hướng nhiều hơn về son dưỡng. Họ tạo ra hỗn hợp từ sáp ong và dầu, đôi khi thêm các loại thảo mộc có mùi thơm và cho một chút màu từ rượu vang đỏ. Đôi khi, họ sử dụng mỡ cừu. Hỗn hợp này có xu hướng tự nhiên và ít nguy hiểm hơn các công thức chế tạo son môi khác.\n" +
                                                                                            "\n" +
                                                                                            "Mỹ\n" +
                                                                                            "\n" +
                                                                                            "Từ thế kỷ 15 đến 18, phụ nữ Mỹ mút chanh để đôi môi đầy đặn và đỏ ửng, mặc dù phương pháp này cực kỳ có hại cho răng.\n" +
                                                                                            "\n" +
                                                                                            "Nữ hoàng Anh Elizabeth I\n" +
                                                                                            "\n" +
                                                                                            "Elizabeth I không chỉ là nữ hoàng vĩ đại của nước Anh, mà còn dẫn đầu xu hướng làm đẹp cho phụ nữ thời kỳ này. Thế kỷ 16, bà sáng tạo cách làm đẹp diện mạo bằng khuôn mặt trắng như phấn và đôi môi màu đen tương phản. \n" +
                                                                                            "\n" +
                                                                                            "Nữ hoàng tin rằng màu đen có sức mạnh ma thuật, có thể tránh khỏi mọi điều đen đủi, kể cả cái chết. Son môi bà dùng chủ yếu được tạo ra từ sáp ong và thuốc nhuộm thực vật. Công thức son môi bao gồm cochineal - một loại côn trùng, kẹo cao su Ả Rập (nhựa cây cứng), lòng trắng trứng và sữa. Bà phát minh chì kẻ môi bằng cách trộn thạch cao với sắc tố đỏ, sau đó để nó khô dưới ánh mặt trời rồi vẽ lên môi.\n" +
                                                                                            "\n" +
                                                                                            "Nhiều thỏi son thời đó được tìm thấy trong thành phần có chứa chì cacbonat, chất gây độc cho cơ thể. Sau khi nữ hoàng Elizabeth qua đời, nhiều nhà nghiên cứu phát hiện lượng lớn chì trên môi bà. Giáo hội sau đó cấm dùng son môi.\n" +
                                                                                            "\n" +
                                                                                            "Thời đại Nữ hoàng Victoria\n" +
                                                                                            "\n" +
                                                                                            "Thời kỳ Nữ hoàng Victoria vào cuối những năm 1800 tiếp tục cấm sử dụng son môi đỏ khi cho rằng đó là vật dụng làm đẹp của gái mại dâm. Tuy nhiên vẫn có người làm trái quy định này, ví dụ nữ diễn viên người Pháp Sarah Bernhardt thoa son môi tại các quán cà phê và trên đường phố.\n" +
                                                                                            "\n" +
                                                                                            "Năm 1915, cây son đầu tiên trong ống kim loại trượt đã được Maurice Levy phát minh và đưa vào thị trường. Son môi trở nên phổ biến, cũng dễ dàng mang theo. Công thức khi ấy của son môi là côn trùng nghiền nát trộn sáp ong và dầu ô liu. Hỗn hợp này sẽ bị ôi trên môi chỉ sau vài giờ bôi, tuy nhiên cũng không ngăn được phụ nữ sử dụng nó để làm đẹp."));
        list.add(new ArticleDTO("8", "Son dưỡng môi cho mùa hanh khô giảm đến 50%", "Son môi chiết xuất từ thiên nhiên cùng thành phần chống thâm, lên màu đẹp là bí quyết cho vẻ ngoài rạng rỡ của phái nữ.\n" +
                                                                                    "\n" +
                                                                                    "Những thỏi son dưỡng môi đang bán giá ưu đãi trên Shop VnExpress. Với những đơn hàng từ 599.000 đồng, người tiêu dùng còn được ưu đãi thêm 10% khi nhập code \"Uudai10\", giảm tối đa 100.000 đồng khi mua tại Shop VnExpress trong ngày 10/10.\n" +
                                                                                    "\n" +
                                                                                    "Son lâu trôi kèm dưỡng ẩm Farmasi\n" +
                                                                                    "\n" +
                                                                                    "Bộ sưu tập của Farmasi gồm các màu sắc ấn tượng, tạo điểm nhấn cho khuôn mặt và làm nên thần thái của một cô gái quyến rũ. Đặc tính lâu phai được hình thành nhờ cao lanh (đất sét trắng) với độ bám dính cao, thúc đẩy hình thành tế bào môi mới, cho môi luôn căng mọng. Sản phẩm còn chứa vitamin E, tinh dầu mắc ca, ngọc trai, cung cấp chất dinh dưỡng cần thiết cho đôi môi mềm mượt, làm giảm sự mất nước, kháng khuẩn, tăng đàn hồi...\n" +
                                                                                    "\n" +
                                                                                    "Màu sắc lên môi đậm, gần như giống hoàn toàn màu mẫu, không bị sai lệch bởi đặc điểm sắc tố trên môi. Loại son này thích hợp dùng cho ban ngày, giúp tôn lên sắc da, dễ dàng phối cùng phụ kiện hoặc các item thời trang."));
        list.add(new ArticleDTO("9", "Son trang điểm dưỡng môi cho mùa thu đông", "Mỹ phẩm Skinlovers mang đến cho phái đẹp sản phẩm son trang điểm kết hợp dưỡng môi thích hợp cho mùa hanh khô.\n" +
                                                                                "\n" +
                                                                                "Lớp da trên cùng của đôi môi mỏng hơn rất nhiều so với các phần còn lại của làn da trên cơ thể và cũng không có tuyến bã nhờn để bảo vệ bên ngoài. Vì vậy, lớp da này dễ bị tổn thương vì yếu tố môi trường như thời tiết, tia UV… hay thói quen sinh hoạt hàng ngày như liếm môi, uống không đủ nước… Đây chính là những tác nhân làm cho làn môi trở nên khô ráp, nứt nẻ, kém tươi sắc theo thời gian và tuổi tác. Do đó, để duy trì vẻ căng mịn, mềm mại và nét xuân trên đôi môi, phái đẹp nên sử dụng sản phẩm son trang điểm kết hợp dưỡng môi. Dòng sản phẩm này sẽ giúp chị em tiết kiệm được ngân sách, thời gian và mà vẫn duy trì được đôi môi xinh xắn, gợi cảm."
                                                                                +"Skinlovers - thương hiệu mỹ phẩm cao cấp đến từ Hàn Quốc nổi tiếng với các sản phẩm kem nền và phấn phủ trang điểm ngọc trai, giới thiệu dòng sản phẩm son trang điểm Skinlovers Sexy Lady có độ dưỡng cao, màu sắc đa dạng. Bộ sưu tập son môi trang điểm cao cấp Skinlovers Sexy Lady có 6 tông màu trẻ trung, lên màu đẹp, tạo hiệu ứng làn môi tươi trẻ, quyến rũ, bền màu. Chỉ một lớp son Skinlovers Sexy Lady mỏng nhẹ bạn có thể tự tin cả ngày, không lo son bị trôi."));
       return list; 
    }
    
    public ArticleDTO getArticleById(String id) {
        for (ArticleDTO a : getAllArticle()) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }
}

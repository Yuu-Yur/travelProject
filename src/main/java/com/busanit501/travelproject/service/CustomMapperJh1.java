package com.busanit501.travelproject.service;

import com.busanit501.travelproject.domain.*;
import com.busanit501.travelproject.dto.*;
import com.busanit501.travelproject.dto.freeboard.FreeBoardJh1DTO;
import com.busanit501.travelproject.dto.member.MemberDTO;
import com.busanit501.travelproject.dto.member.MemberFullDTO;
import com.busanit501.travelproject.dto.reservation.ReservationViewJh1DTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  기존의 ModelMapper와 같은 역할을 하되, 필요한 부분만큼만 구현된 Mapper 클래스
 * </p>
 * @author 원종호
 */
@Component
public class CustomMapperJh1 {

  public LocationValueJh1DTO locationToDTO(Location location) {
    return LocationValueJh1DTO.builder()
      .locationNo(location.getLocationNo())
      .city(location.getCity())
      .country(location.getCountry())
      .build();
  }

  public ReservationViewJh1DTO reservationToViewDTO(Reservation r) {
    return ReservationViewJh1DTO.builder()
      .reservationNo(r.getReservationNo())
      .memberNo(r.getMember().getMemberNo())
      .memberName(r.getMember().getMemberName())
      .productNo(r.getProduct().getProductNo())
      .productName(r.getProduct().getName())
      .ReservationOrder(r.getReservationOrder())
      .regDate(r.getRegDate())
      .modDate(r.getModDate())
      .build();
  }

  public ReviewJh1DTO reviewToDTO(Review review) {
    return ReviewJh1DTO.builder()
      .reviewNo(review.getReviewNo())
      .reviewContent(review.getReviewContent())
      .rating(review.getRating())
      .productNo(review.getProduct().getProductNo())
      .productName(review.getProduct().getName())
      .memberNo(review.getMember().getMemberNo())
      .memberName(review.getMember().getMemberName())
      .regDate(review.getRegDate())
      .modDate(review.getModDate())
      .build();
  }

  public FreeBoardJh1DTO boardToDTO(FreeBoard fb) {
    return FreeBoardJh1DTO.builder()
      .freeBoardNo(fb.getFreeBoardNo())
      .title(fb.getTitle())
      .content(fb.getContent())
      .regDate(fb.getRegDate())
      .modDate(fb.getModDate())
      .memberNo(fb.getMember().getMemberNo())
      .memberName(fb.getMember().getMemberName())
      .build();
  }

  public ProductJh1DTO productToCompactDTO(Product product) {
    return ProductJh1DTO.builder()
      .productNo(product.getProductNo())
      .name(product.getName())
      .description(product.getDescription())
      .price(product.getPrice())
      .locationNo(product.getLocation().getLocationNo())
      .location(locationToDTO(product.getLocation()))
      .startDate(product.getStartDate())
      .endDate(product.getEndDate())
      .capacity(product.getCapacity())
      .imagePath(product.getImagePath())
      .build();
  }

  public ProductJh1DTO productToFullDTO(Product product) {
    ProductJh1DTO dto = productToCompactDTO(product);
    List<ReservationViewJh1DTO> reservationDTOList = product.getReservations().stream().map(this::reservationToViewDTO).toList();
    List<ReviewJh1DTO> reviewDTOList = product.getReviews().stream().map(this::reviewToDTO).toList();
    dto.setReservations(reservationDTOList);
    dto.setReviews(reviewDTOList);
    return dto;
  }

  public MemberDTO memberToDTO(Member member) {
    return MemberDTO.builder()
      .memberNo(member.getMemberNo())
      .memberID(member.getMemberID())
      .memberName(member.getMemberName())
      .memberEmail(member.getMemberEmail())
      .memberPhone(member.getMemberPhone())
      .memberPoint(member.getMemberPoint())
      .memberUUID(member.getMemberUUID())
      .regDate(member.getRegDate())
      .modDate(member.getModDate())
      .build();
  }

  public MemberFullDTO memberToFullDTO(Member member) {
    List<ReservationViewJh1DTO> reservationList = member.getReservations().stream().map(
      r -> ReservationViewJh1DTO.builder()
        .reservationNo(r.getReservationNo())
        .memberNo(member.getMemberNo())
        .memberName(member.getMemberName())
        .productNo(r.getProduct().getProductNo())
        .productName(r.getProduct().getName())
        .ReservationOrder(r.getReservationOrder())
        .regDate(r.getRegDate())
        .modDate(r.getModDate())
        .build()
    ).toList();

    List<ReviewJh1DTO> reviewList = member.getReviews().stream().map(this::reviewToDTO).toList();

    List<FreeBoardJh1DTO> freeBoardList = member.getFreeBoards().stream().map(this::boardToDTO).toList();

    List<ReplyJh1DTO> replyList = member.getReplies().stream().map(
      re -> ReplyJh1DTO.builder()
        .replyNo(re.getReplyNo())
        .content(re.getContent())
        .memberNo(member.getMemberNo())
        .build()
    ).toList();

    return MemberFullDTO.builder()
      .memberNo(member.getMemberNo())
      .memberID(member.getMemberID())
      .memberName(member.getMemberName())
      .memberEmail(member.getMemberEmail())
      .memberPhone(member.getMemberPhone())
      .memberPoint(member.getMemberPoint())
      .regDate(member.getRegDate())
      .modDate(member.getModDate())
      .reservations(reservationList)
      .reviews(reviewList)
      .freeBoards(freeBoardList)
      .replies(replyList)
      .build();
  }

}

package dto;

public record BookRequest(
        String isbn,
        int requiredQuantity,
        String email,
        String address
) {
}

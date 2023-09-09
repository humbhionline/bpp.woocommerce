package in.succinct.bpp.woocommerce.model;

import in.succinct.beckn.BecknObject;
import in.succinct.beckn.BecknObjectsWithId;
import in.succinct.beckn.BecknStrings;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Products extends BecknObjectsWithId<Products.Product> {

    public Products(JSONArray array) {
        super(array);
    }

    public static class Product extends WooCommerceObjectWithId {

        public Product(JSONObject object) {
            super(object);
        }

        public String getStatus() {
            return get(AttributeKey.status.getKey());
        }

        public String getName() {
            return get(AttributeKey.name.getKey());
        }

        public String getType() {
            return get(AttributeKey.type.getKey());
        }

        public String getStockStatus() {
            return get(AttributeKey.stock_status.getKey());
        }

        public boolean isPurchasable() {
            return getBoolean(AttributeKey.purchasable.getKey());
        }

        public double getRegularPrice() {
            String priceString = get(AttributeKey.regular_price.getKey());
            try {
                return Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                // Handle the case where the string cannot be parsed as a double
                // You can log an error or return a default value as needed.
                return 0.0; // Default value for invalid price strings
            }
        }

        public double getPrice() {
            String priceString = get(AttributeKey.price.getKey());
            try {
                return Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                // Handle the case where the string cannot be parsed as a double
                // You can log an error or return a default value as needed.
                return 0.0; // Default value for invalid price strings
            }
        }

        public String getWeight() {
            return get(AttributeKey.weight.getKey());
        }

        public String getParentId() {

            return get(AttributeKey.parent_id.getKey()).toString();
        }

        public String getSku() {
            return get(AttributeKey.sku.getKey());
        }

        public String getDescription() {
            return get(AttributeKey.description.getKey());
        }

        public String getShortDescription() {
            return get(AttributeKey.short_description.getKey());
        }

        public String getTaxStatus() {
            return get(AttributeKey.tax_status.getKey());
        }

        public ProductDimension getDimension() {
            return get(ProductDimension.class, AttributeKey.dimension.getKey());
        }


        public ProductCategories getCategories() {
            return get(ProductCategories.class, AttributeKey.categories.getKey());
        }

        public ProductImages getImages() {
            return get(ProductImages.class, AttributeKey.images.getKey());
        }

        public ProductAttributes getAttributes() {
            return get(ProductAttributes.class, AttributeKey.attributes.getKey());
        }

        public ProductVariations getVariations() {
            return get(ProductVariations.class, AttributeKey.variations.getKey());
        }

        public ProductTags getTags() {
            return get(ProductTags.class, AttributeKey.tags.getKey());
        }


    }

    public static class ProductDimension extends BecknObject {
        public ProductDimension(JSONObject object) {
            super(object);
        }

        public String getLength() {
            return get(AttributeKey.length.getKey());
        }

        public String getWidth() {
            return get(AttributeKey.width.getKey());
        }

        public String getHeight() {
            return get(AttributeKey.height.getKey());
        }


    }

    public static class ProductCategories extends BecknObjectsWithId<ProductCategory> {

        public ProductCategories(JSONArray array) {
            super(array);
        }
    }

    public static class ProductCategory extends WooCommerceObjectWithId {
        public ProductCategory(JSONObject object) {
            super(object);
        }

        public String getName() {
            return get(AttributeKey.name.getKey());
        }
    }

    public static class ProductTags extends BecknObjectsWithId<ProductTag> {
        public ProductTags(JSONArray array) {
            super(array);
        }
    }

    public static class ProductTag extends WooCommerceObjectWithId {
        public ProductTag(JSONObject object) {
            super(object);
        }

        public String getName() {
            return get(AttributeKey.name.getKey());
        }
    }

    public static class ProductImages extends BecknObjectsWithId<ProductImage> {

        public ProductImages(JSONArray array) {
            super(array);
        }

    }

    public static class ProductImage extends WooCommerceObjectWithId {

        public ProductImage(JSONObject object) {
            super(object);
        }

        public String getSrc() {
            return get("src");
        }

    }

    public static class ProductAttributes extends BecknObjectsWithId<ProductAttribute> {

        public ProductAttributes(JSONArray array) {
            super(array);
        }

    }

    public static class ProductAttribute extends WooCommerceObjectWithId {

        public ProductAttribute(JSONObject object) {
            super(object);
        }

        public String getName() {
            return get(AttributeKey.name.getKey());
        }

        public int getPosition() {
            return getInteger(AttributeKey.position.getKey());
        }

        public BecknStrings getOptions() {
            return get(BecknStrings.class, AttributeKey.options.getKey());
        }

    }

    public static class ProductVariations extends BecknObjectsWithId<ProductVariation> {
        public ProductVariations(JSONArray array) {
            super(array);
        }
    }

    public static class ProductVariation extends WooCommerceObjectWithId {
        public ProductVariation(JSONObject object) {
            super(object);
        }
    }

    public static enum AttributeKey {
        images("images"),
        attributes("attributes"),
        default_attributes("default_attributes"),
        status("status"),
        stock_status("stock_status"),
        purchasable("purchasable"),
        length("length"),
        width("width"),
        height("height"),
        name("name"),
        position("position"),
        options("options"),
        type("type"),
        price("price"),
        regular_price("regular_price"),
        weight("weight"),
        dimension("dimension"),
        parent_id("parent_id"),
        categories("categories"),
        tags("tags"),
        variations("variations"),
        page("page"),
        per_page("per_page"),
        id("id"),
        sku("sku"),
        description("description"),
        short_description("short_description"),
        tax_status("tax_status"),
        tax_class("tax_class"),


        ;

        private final String key;

        AttributeKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static String getVariantApiEndpoint(String variationId) {
            return String.format("/settings/%s/%s", variationId, AttributeKey.variations.getKey());
        }
    }

}

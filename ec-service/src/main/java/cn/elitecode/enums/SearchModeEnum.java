package cn.elitecode.enums;

/**
 * 搜索模式枚举类
 */
public enum SearchModeEnum {
    MYSQL("mysql", "questionServiceImpl"),
    ELASTICSEARCH("elasticsearch", "esQuestionServiceImpl");

    private SearchModeEnum(String mode, String strategy) {
        this.mode = mode;
        this.strategy = strategy;
    }

    private final String mode;
    private final String strategy;

    public static String getStrategy(String mode) {
        for (SearchModeEnum searchModeEnum : SearchModeEnum.values()) {
            if (searchModeEnum.mode.equals(mode)) {
                return searchModeEnum.strategy;
            }
        }
        return null;
    }
}

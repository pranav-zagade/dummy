package com.verinite.dummyInterestApp.exception;
import java.util.Map;

public class ApiError {
    private String code;
    private String message;
 
    private String version;
    private Map<String, Object> details;
    private ApiError innerError;
    private String debugId;
    private String reference;

    public static ApiError.ApiErrorBuilder builder() {
        return new ApiError.ApiErrorBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getVersion() {
        return this.version;
    }

    public Map<String, Object> getDetails() {
        return this.details;
    }

    public ApiError getInnerError() {
        return this.innerError;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public String getReference() {
        return this.reference;
    }

    public ApiError(String code, String message, String version, Map<String, Object> details, ApiError innerError, String debugId, String reference) {
        this.code = code;
        this.message = message;
        this.version = version;
        this.details = details;
        this.innerError = innerError;
        this.debugId = debugId;
        this.reference = reference;
    }

    public static class ApiErrorBuilder {
        private String code;
        private String message;
        private String version;
        private Map<String, Object> details;
        private ApiError innerError;
        private String debugId;
        private String reference;

        ApiErrorBuilder() {
        }

        public ApiError.ApiErrorBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ApiError.ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiError.ApiErrorBuilder version(String version) {
            this.version = version;
            return this;
        }

        public ApiError.ApiErrorBuilder details(Map<String, Object> details) {
            this.details = details;
            return this;
        }

        public ApiError.ApiErrorBuilder innerError(ApiError innerError) {
            this.innerError = innerError;
            return this;
        }

        public ApiError.ApiErrorBuilder debugId(String debugId) {
            this.debugId = debugId;
            return this;
        }

        public ApiError.ApiErrorBuilder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.code, this.message, this.version, this.details, this.innerError, this.debugId, this.reference);
        }

        public String toString() {
            return "ApiError.ApiErrorBuilder(code=" + this.code + ", message=" + this.message + ", version=" + this.version + ", details=" + this.details + ", innerError=" + this.innerError + ", debugId=" + this.debugId + ", reference=" + this.reference + ")";
        }
    }
}
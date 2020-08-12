package br.com.boraviajar.apiwatcher.service

import br.com.boraviajar.apiwatcher.exception.QueryException
import mu.KotlinLogging
import org.elasticsearch.action.support.IndicesOptions
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.reindex.DeleteByQueryRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TravelServiceImpl(val restHighLevelClient: RestHighLevelClient) : TravelService {

    private val logger = KotlinLogging.logger {};

    @Value("\${index}")
    private val index : String? = null;

    override fun deleteById(id: String) {
        try {
            logger.debug { "Preparando para remover viagem com id: $id" };
            executeDeleteByQuery(index, QueryBuilders.matchQuery("_id", id));
        } catch (e: Exception) {
            logger.error { "Erro ao excluir de viagem com id: $id." };
            throw QueryException("Erro ao excluir viagem. ${e.message}");
        }
    }

    override fun deleteTravelsByDate(date: LocalDate) {
        try {
            logger.debug { "Preparando para remover registros de viagem com data de retorno inferior a 14 dias a partir da data: $date" }
            executeDeleteByQuery(index, QueryBuilders.matchQuery("dataRetorno", date))
        } catch (e: Exception) {
            logger.error { "Erro ao excluir registros de viagem com com data de retorno inferior a 14 dias a partir da data: $date" }
            throw QueryException("Erro ao excluir registros. ${e.message}");
        }
    }

    private fun executeDeleteByQuery(index: String?, query: QueryBuilder){
        val deleteByQueryRequest = DeleteByQueryRequest(index);
        deleteByQueryRequest.setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN);
        deleteByQueryRequest.setQuery(query);
        deleteByQueryRequest.isRefresh = true;
        val deleted = restHighLevelClient.deleteByQuery(deleteByQueryRequest, RequestOptions.DEFAULT).deleted;
        logger.info { "$deleted - registros removidos." };
    }
}